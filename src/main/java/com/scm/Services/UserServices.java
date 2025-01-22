package com.scm.Services;

import java.util.List;

import com.scm.entities.User;

public interface UserServices {
    User saveUser(User user);
    User getUser(String id);
    User updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String UserId);
    boolean isUserExistByUserEmail(String email);
    List<User> getAllUser();

}
