package com.example.oauth2resourceserver.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserInfoController {

    @GetMapping("/userinfo")
    public ResponseEntity<?> userInfo(Principal principal,
                                      HttpServletRequest request) {
        return ResponseEntity.ok(principal);
    }
}
