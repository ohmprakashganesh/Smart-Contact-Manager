package com.scm.Services;

import java.util.List;

import com.scm.entities.User;

public interface UserServices {
    User saveUser(User user);
    User getUser(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    boolean isUserExist(Long UserId);
    boolean isUserExistByUserEmail(String email);
    List<User> getAllUser();

}
