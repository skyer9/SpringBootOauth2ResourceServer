package com.example.oauth2resourceserver.web;

import com.example.oauth2resourceserver.domain.User;
import com.example.oauth2resourceserver.domain.UserRepository;
import com.example.oauth2resourceserver.web.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserInfoController {

    private final UserRepository userRepository;

    @GetMapping("/userinfo")
    public ResponseEntity<?> userInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String name = authentication.getName();
        UserProfile profile = new UserProfile(name);

        OAuth2Authentication oAuth2Authentication;
        if (authentication instanceof OAuth2Authentication) {
            oAuth2Authentication = (OAuth2Authentication) authentication;
            Set<String> scopes = oAuth2Authentication.getOAuth2Request().getScope();

            Optional<User> user = userRepository.findByUid(name);
            if (user.isEmpty()) {
                return ResponseEntity.ok(profile);
            }

            if (scopes.contains("email")) {
                profile.setEmail(user.get().getEmail());
            }
        }

        return ResponseEntity.ok(profile);
    }
}
