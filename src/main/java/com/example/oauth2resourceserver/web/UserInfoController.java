package com.example.oauth2resourceserver.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserInfoController {

    @GetMapping("/read/")
    public ResponseEntity<?> read() {

        String result = "read";

        return ResponseEntity.ok(result);
    }

    @GetMapping("/write/")
    public ResponseEntity<?> write() {

        String result = "write";

        return ResponseEntity.ok(result);
    }
}
