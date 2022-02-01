package com.lenskartapp.service;

import com.lenskartapp.exceptions.UserNotFoundException;
import com.lenskartapp.model.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId) throws UserNotFoundException;
    List<User> allUsers();

    User getById(Integer userId) throws UserNotFoundException;

    User getByEmailandPassword(String email, String password) throws UserNotFoundException;

    User getByMobileandPassword(String mobile, String password) throws UserNotFoundException;


}
