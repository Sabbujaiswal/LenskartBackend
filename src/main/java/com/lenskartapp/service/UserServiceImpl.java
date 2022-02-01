package com.lenskartapp.service;

import com.lenskartapp.exceptions.UserNotFoundException;
import com.lenskartapp.model.User;
import com.lenskartapp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
   IUserRepository userRepository;
    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteUser(int userId) throws UserNotFoundException {
       userRepository.findById(userId);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer userId) throws UserNotFoundException {
        User user=null;
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User with this id not found"));
    }

    @Override
    public User getByEmailandPassword(String email, String password) throws UserNotFoundException {
        User user=userRepository.findByEmailAndPassword( email, password);
        if(user==null){
            throw  new UserNotFoundException("User not found with this email and password" + email + " " + password);
        }
        return user;
    }

    @Override
    public User getByMobileandPassword(String mobile, String password) throws UserNotFoundException {

        User user=userRepository.findByMobileAndPassword(mobile,password);
        if(user==null){
            throw new UserNotFoundException(("User not found with this mobile number and password"));
        }
        return user;
    }
}
