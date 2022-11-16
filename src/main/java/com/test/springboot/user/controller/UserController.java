package com.test.springboot.user.controller;

import com.test.springboot.user.exception.*;
import com.test.springboot.user.model.User;
import com.test.springboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public User getByUsername(@PathVariable String username) {
        try{
            return this.userService.getUserByUsername(username);
        }
        catch(Exception e){
            return null;
        }
    }

    @PostMapping
    public User save(@RequestBody User newUser){
        if( newUser.getUsername() == null ||
            newUser.getPassword() == null ||
            newUser.getResidenceCountry() == null ||
            newUser.getBirthDate() == null
        ){
            throw new MissingFieldException();
        }
        else if(newUser.getUsername().length()<8 || newUser.getPassword().length()<8){
            throw new FormatException();
        }
        else if(newUser.getAge()<18){
            throw new Under18Exception();
        }
        else if(!newUser.getResidenceCountry().equalsIgnoreCase("france")){
            throw new NotFrenchResidentException();
        }
        else if(newUser.getPhoneNumber() != null && newUser.getPhoneNumber().length() != 10){
                throw new FormatException();
        }
        else if(newUser.getGender() != null && newUser.getGender().length() != 1){
                throw new FormatException();
        }
        else{
            if(this.userService.findAll().size() != 0){
                if(this.userService.getUserByUsername(newUser.getUsername()) != null){
                    throw new UsernameUsedException();
                }
                return this.userService.saveOrUpdate(newUser);
            }
            return this.userService.saveOrUpdate(newUser);

        }
    }

    @DeleteMapping()
    public void clean(){
        this.userService.clean();
    }
}
