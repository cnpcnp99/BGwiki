package com.euijae.demo.service;

import com.euijae.demo.domain.User;
import com.euijae.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return user;
    }


    public void registerUser(User user) {
        userRepository.save(user);
    }

    public Boolean login(String email, String password) {
        List<User> userList = userRepository.findByEmail(email);
        if(userList.size() == 0)
            return false;
        User user = userList.get(0);
        return user.getPassword().equals(password);
    }
}
