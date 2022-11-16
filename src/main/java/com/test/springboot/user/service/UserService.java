package com.test.springboot.user.service;

import com.test.springboot.user.model.User;
import com.test.springboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> findAll() {
        return (List<User>) this.repository.findAll();
    }


    public long size(){
        return this.repository.count();
    }
    public User getUserByUsername(String username) {
        try{
            return this.repository.findByUsername(username);
            //            return this.repository.findById(username).get();
        }
        catch(NoSuchElementException e){
            return null;
        }
    }

    public User saveOrUpdate(User user) {
        return this.repository.save(user);
    }

    public void delete(String username) {
        this.repository.deleteById(username);
    }


    public void clean(){
        this.repository.deleteAll();
    }

}
