package com.product.Backend_Solar.Controller;


import com.product.Backend_Solar.Entity.Users;
import com.product.Backend_Solar.Repository.UsersRepo;
import com.product.Backend_Solar.Service.UserService;
import com.product.Backend_Solar.UsersDTO.UsersDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/solar")
public class Controller {


    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepo repo;



    @PostMapping(path = "/register")
    public ResponseEntity<UsersDTO> create_User(@RequestBody UsersDTO usersDTO)
    {
        return new ResponseEntity<> (userService.create_User(usersDTO), HttpStatus.CREATED);
    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> userLogin(@RequestBody Users user)
    {
        System.out.println(user);
       Users usersDTO = repo.findByEmail(user.getEmail());
       if(usersDTO.getPassword().equals(user.getPassword()))
           return ResponseEntity.ok(usersDTO);
       return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }



}


