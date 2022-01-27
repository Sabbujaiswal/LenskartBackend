package com.lenskartapp.controllers;


import com.lenskartapp.model.Frame;
import com.lenskartapp.model.User;
import com.lenskartapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-api")
@CrossOrigin("http://localhost:4200")
public class UserController {

    IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users/add-user")
    ResponseEntity<User> addUser(@RequestBody User user) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding user");
        User nuser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuser);
    }

    @PutMapping("/users")
    ResponseEntity<Void> updateUSer(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating user");
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/users/id/{userid}")
    public ResponseEntity<String> deleteUser(@PathVariable("userid") int userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting frame");
       userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }


    @GetMapping("/users/id/{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId") Integer userId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting by id");
        User user=userService.getById(userId);
        return ResponseEntity.ok().headers(headers).body(user);
    }
    @GetMapping("/users/email/{email}/password/{password}")
    public ResponseEntity<User> getByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting by email and password");
        User user=userService.getByEmailandPassword(email,password);
        return ResponseEntity.ok().headers(headers).body(user);
    }
    @GetMapping("/users/mobile/{mobile}/password/{password}")
    public ResponseEntity<User> getByMobileAndPassword(@PathVariable("mobile") String mobile,@PathVariable("password") String password){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting by Mobile and password");
        User user=userService.getByMobileandPassword(mobile,password);
        return ResponseEntity.ok().headers(headers).body(user);
    }

}
