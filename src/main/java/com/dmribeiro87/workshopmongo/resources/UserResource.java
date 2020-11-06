package com.dmribeiro87.workshopmongo.resources;

import com.dmribeiro87.workshopmongo.domain.User;
import com.dmribeiro87.workshopmongo.dto.UserDTO;
import com.dmribeiro87.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>>  findAll(){

        List<User> list = service.findAll();
        List<UserDTO> dtoList = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<User> findById(String id){
//
//    }


}
