package com.euijae.demo.repository;

import com.euijae.demo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.merge(user);
    }

    public User findOne(Long original_id) {
        System.out.println("Rep findOne");
        return em.find(User.class, original_id);
    }
}