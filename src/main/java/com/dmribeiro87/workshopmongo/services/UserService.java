package com.dmribeiro87.workshopmongo.services;

import com.dmribeiro87.workshopmongo.domain.User;
import com.dmribeiro87.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
