package com.euijae.demo.service;

import com.euijae.demo.domain.User;
import com.euijae.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        User user = userRepository.findOne(id);
        System.out.println(user.getId());
        return user;
    }


}
