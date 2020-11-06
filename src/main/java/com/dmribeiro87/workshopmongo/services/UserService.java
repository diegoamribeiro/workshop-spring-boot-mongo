package com.dmribeiro87.workshopmongo.services;

import com.dmribeiro87.workshopmongo.domain.User;
import com.dmribeiro87.workshopmongo.repository.UserRepository;
import com.dmribeiro87.workshopmongo.services.exception.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
       Optional<User> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado"));
    }



}
