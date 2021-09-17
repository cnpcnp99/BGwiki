package com.euijae.demo.controller;

import com.euijae.demo.domain.User;
import com.euijae.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

//    @PostMapping("/api/users")
//    public User user() {
//        System.out.println("/api/users ON");
//
//
//        return user;
//    }

    @PostMapping("/api/users/save")
    public void saveUser() {
        User user = new User();
        user.setEmail("tub123@naver.com");
        user.setName("jeong");
        user.setPhoneNumber("010-0001-0002");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        System.out.println("postMapping ing");

        userService.saveUser(user);
        System.out.println("save clear");
    }

    @PostMapping("/api/users/find")
    public User getUser() {
        User user = userService.findUserById(1L);
        return user;

    }

    @GetMapping("/abc")
    public String str(){
        return "abc";
    }
}
