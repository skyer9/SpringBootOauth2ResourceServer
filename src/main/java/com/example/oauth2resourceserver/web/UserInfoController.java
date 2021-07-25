package com.example.oauth2resourceserver.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UserInfoController {

    /*
        //Build some dummy data to return for testing
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = user.getUsername() + "@howtodoinjava.com";

        UserProfile profile = new UserProfile();
        profile.setName(user.getUsername());
        profile.setEmail(email);

        return ResponseEntity.ok(profile);
    * */

    @GetMapping("/userinfo")
    public ResponseEntity<?> userInfo(Principal principal,
                                      HttpServletRequest request, @RequestParam HashMap<String,String> paramMap) {
        return ResponseEntity.ok(principal);
    }
}
