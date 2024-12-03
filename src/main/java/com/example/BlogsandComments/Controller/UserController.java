package com.example.BlogsandComments.Controller;


import com.example.BlogsandComments.DTO.LoginDto;
import com.example.BlogsandComments.DTO.ResponseDto;
import com.example.BlogsandComments.DTO.UserDetailsDto;
import com.example.BlogsandComments.models.User;
import com.example.BlogsandComments.service.impl.UserServiceImpl;
import com.example.demo.acountsconstants.UserConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/v1/user")
@Component
public class UserController {
    @Autowired
    private UserServiceImpl service;
    @PostMapping("/")
    public ResponseEntity<ResponseDto> signup(@RequestBody User user){
        service.registration(user);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> getUserById(@PathVariable int id) {
        Optional<UserDetailsDto> user = Optional.ofNullable(service.getUserDetailsById(id));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping ("/all")
    public List<UserDetailsDto> multipleUsers(@RequestBody List<Integer> ids){
        List<UserDetailsDto> users = service.getUserDetailsByIds(ids);
        return  users;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto){
        service.Login(loginDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto(UserConstants.STATUS_200,UserConstants.MESSAGE_200));
    }



}
