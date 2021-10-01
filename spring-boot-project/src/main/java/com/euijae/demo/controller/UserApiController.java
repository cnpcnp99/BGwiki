package com.euijae.demo.controller;

import com.euijae.demo.domain.User;
import com.euijae.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/users/login")
    public Map<String, String> loginUser(@RequestBody Map<String, Object>loginForm) {
        System.out.println("/api/users/login ON");
        String email = loginForm.get("email").toString();
        String password = loginForm.get("password").toString();
        Boolean result = userService.login(email, password);

        Map<String, String> map = new HashMap<>();
        if (result) {
            map.put("result", "success");
            map.put("email", email);
            System.out.println("[users/register] : ['" + email + "' login SUCCESS]");
        }
        else{
            map.put("result", "failed");
            System.out.println("[users/register] : ['" + email + "' login FAIL]");
        }
        return map;
    }

    @PostMapping("/api/users/register")
    public Map<String, Boolean> registerUser(@RequestBody Map<String, Object>userForm){
        User user = User.builder()
                .name(userForm.get("name").toString())
                .email(userForm.get("email").toString())
                .phoneNumber("010-0001-0002")
                .password(userForm.get("password").toString())
                .createdAt(LocalDateTime.now())
                .createdBy("admin")
                .build();
        userService.registerUser(user);
        System.out.println("Register user:(maybe) SUCCESS");
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("success", true);
        return map;
        //TODO 1: 예외처리
        //TODO 2: 프론트 단에서 아이디 체크 시 api 요청하는 거 수정
        //TODO 3: auth 완성
    }

    @PostMapping("/api/users/save")
    public void saveUser() {
        User user = new User();
        user.setEmail("tub12345@naver.com");
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

//    @GetMapping("/api/abc")
//    public ResponseEntity<String> str(){
//        return ResponseEntity.ok("helloo");
//    }


}
