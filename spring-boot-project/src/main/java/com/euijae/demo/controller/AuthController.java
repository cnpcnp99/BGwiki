package com.euijae.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/api/auth/getAuth")
    public Map<String, Boolean> auth() {
        System.out.println("/api/user/auth ON");
        Map<String, Boolean> map = new HashMap<>();
        map.put("isAuth", false);
        map.put("isAdmin", true);
        return map;
    }

}
