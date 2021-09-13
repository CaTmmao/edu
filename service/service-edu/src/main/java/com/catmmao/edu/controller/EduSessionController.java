package com.catmmao.edu.controller;

import java.util.HashMap;
import java.util.Map;

import com.catmmao.utils.data.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/session")
public class EduSessionController {
    @PostMapping("/login")
    public ResponseEntity<CommonResponse<Map<String, String>>> login() {
        Map<String, String> map = new HashMap<>();
        map.put("token", "1111");
        return ResponseEntity.ok(CommonResponse.ok(map));
    }

    @GetMapping("/info")
    public ResponseEntity<CommonResponse<Map<String, String>>> info() {
        Map<String, String> map = new HashMap<>();
        map.put("roles", "1111");
        map.put("name", "aaa");
        map.put("avatar", "aaa");
        return ResponseEntity.ok(CommonResponse.ok(map));
    }
}
