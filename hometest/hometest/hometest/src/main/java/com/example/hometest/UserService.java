package com.example.hometest;

import java.util.List;

import com.example.hometest.User.User;

public interface UserService {
    User saveUser(User User);

    List<User> getAllUsers();

    User getUserByUserId(long UserId);

    User updateUser(User User, long UserId);

    void deleteUser(long UserId);
}