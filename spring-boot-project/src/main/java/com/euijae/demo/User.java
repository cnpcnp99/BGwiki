package com.euijae.demo;


import lombok.Getter;
import lombok.Setter;


@Getter
public class User {
    int id;
    String username;
    String password;
    String email;

    public User(int id, String username, String password, String email){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId(){
        return this.id;
    }
    public String getPassword(){
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }
}
