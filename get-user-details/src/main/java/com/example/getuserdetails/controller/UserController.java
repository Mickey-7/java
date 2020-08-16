package com.example.getuserdetails.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @GetMapping("/user")
    public String userInfo(Authentication authentication){
        String userName = authentication.getName();
        String role = authentication.getAuthorities().stream().findAny().get().getAuthority();


        //2.1 User authority/role can retrieve by user Enhanced-For-Loop also:
        for(GrantedAuthority authority : authentication.getAuthorities()){
             String auth = authentication.getAuthorities().toString();
            System.out.println(auth);   //[ROLE_ADMIN]
             String principal = authentication.getPrincipal().toString();
            System.out.println(principal);
            //org.springframework.security.core.userdetails.User@bf8abce4:
            // Username: manish; Password: [PROTECTED]; Enabled: true;
            // AccountNonExpired: true; credentialsNonExpired: true;
            // AccountNonLocked: true; Granted Authorities: ROLE_ADMIN
             String details = authentication.getDetails().toString();
            System.out.println(details);
            //org.springframework.security.web.authentication.WebAuthenticationDetails@ffff4c9c:
            // RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: 066108559441B44D8B6140628CB6BACA
            System.out.println(authentication.getCredentials());


        }


        //Alternatively, we can also use the getPrincipal() method:
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("User has authorities: "+userDetails.getAuthorities());
        //User has authorities: [ROLE_ADMIN]

        return "Your username is : "+userName+ " and your role is : "+role;
    }
}
