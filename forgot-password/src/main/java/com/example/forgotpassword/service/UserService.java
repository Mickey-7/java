package com.example.forgotpassword.service;

import com.example.forgotpassword.domain.User;
import com.example.forgotpassword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    private UserRepository userRepository;

    /**
     * Generate unique token. You may add multiple parameters to create a strong
     * token.
     *
     * @return unique token
     */
    private String generateToken(){
        StringBuilder token = new StringBuilder();
        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }

    public String forgotPassword(String email){
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

        if (!userOptional.isPresent()){
            return "Invalid email id";
        }

        User user = userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());
        user = userRepository.save(user);
        return user.getToken();
    }


    /**
     * Check whether the created token expired or not.
     *
     * @param tokenCreationDate
     * @return true or false
     */
    private boolean isTokenExpired(final  LocalDateTime tokenCreationDate){
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);
        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }

    public String resetPassword(String token, String password){
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByToken(token));
        if (!userOptional.isPresent()){
            return "Invalid token";
        }

        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();
        if (isTokenExpired(tokenCreationDate)){
            return "Token expired";
        }

        User user = userOptional.get();
        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);
        userRepository.save(user);

        return "Your password successfully updated";

    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

}
