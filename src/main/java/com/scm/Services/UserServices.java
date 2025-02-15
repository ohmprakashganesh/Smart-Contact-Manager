package com.scm.Services;

import java.util.List;

import com.scm.entities.User;

public interface UserServices {
    User saveUser(User user);
    User getUser(Long id);
    User getUserByEmail(String email);
    User updateUser(User user);
    boolean isUserExist(Long UserId);
    boolean isUserExistByUserEmail(String email);
    List<User> getAllUser();

}
