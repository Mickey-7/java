package com.example.dtomappingh2springboot.service;

import com.example.dtomappingh2springboot.domain.Location;
import com.example.dtomappingh2springboot.domain.User;
import com.example.dtomappingh2springboot.dto.UserLocationDTO;
import com.example.dtomappingh2springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapService extends ModelMapper{
    @Autowired
    private UserRepository userRepository;

    //---------------for manual mapping----------------------//

//    private UserLocationDTO convertToUserLocationDTO(User user){
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setUsername(user.getUsername());
//        // create location object the set to user.getLocation()
//        // link between user and location
//        Location location = user.getLocation();
//        userLocationDTO.setLat(location.getLat());
//        userLocationDTO.setLng(location.getLng());
//        userLocationDTO.setPlace(location.getPlace());
//        return userLocationDTO;
//    }
//
//    public List<UserLocationDTO> getAllUserLocation(){
//        return userRepository
//                    .findAll()
//                    .stream()
//                    .map( user -> convertToUserLocationDTO(user))
//                    .collect(Collectors.toList());
//    }

    //----------------------------using ModelMapper------------------------------//

    @Autowired
    private ModelMapper modelMapper;

    private UserLocationDTO convertToUserLocation(User user) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = modelMapper.map(user, UserLocationDTO.class);
        return userLocationDTO;

    }

    public List<UserLocationDTO> getAllUserLocation(){
        return userRepository.findAll()
                .stream()
                .map(user -> convertToUserLocation(user))
                .collect(Collectors.toList());
    }
}
