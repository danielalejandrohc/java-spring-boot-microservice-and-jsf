package com.danielalejandrohc.rest;

import com.danielalejandrohc.db.model.UserStore;
import com.danielalejandrohc.db.repository.UserStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserStoreService {
    @Autowired
    private UserStoreRepository service;

    @PostMapping(path = "/users")
    public UserStore findByUsernameAndPassword(String username, String password) {
        return service.findByUsernameAndPassword(username, password);
    }
}
