package com.lenskartapp.repository;

import com.lenskartapp.exceptions.FrameNotFoundException;
import com.lenskartapp.exceptions.UserNotFoundException;
import com.lenskartapp.model.Frame;
import com.lenskartapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserRepository  extends JpaRepository<User, Integer> {


    User findById(int userId) throws UserNotFoundException;

    User findByEmailAndPassword(String email, String password) throws UserNotFoundException;

    User  findByMobileAndPassword(String mobile, String password) throws UserNotFoundException;




}
