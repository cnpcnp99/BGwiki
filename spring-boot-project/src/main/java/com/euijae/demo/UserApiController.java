package com.euijae.demo;

import com.euijae.demo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @PostMapping("/api/users")
    public User user() {
        System.out.println("UserApiController 진입");

        User user = new User(1, "홍길동", "ma123", "1234");

        return user;
    }

    @GetMapping("/abc")
    public String str(){
        return "abc";
    }
}
