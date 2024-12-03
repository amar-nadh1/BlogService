package com.example.BlogsandComments.service.impl;


import com.example.BlogsandComments.DTO.LoginDto;
import com.example.BlogsandComments.DTO.UserDetailsDto;
import com.example.BlogsandComments.MapperClass.LoginMapper;
import com.example.BlogsandComments.exception.LoginFailedException;
import com.example.BlogsandComments.exception.UserAlreadyExistsException;
import com.example.BlogsandComments.models.User;
import com.example.BlogsandComments.repository.UserRepo;
import com.example.BlogsandComments.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl  {
    @Autowired
    private UserRepo userRepo;

    public void registration(User user) {
        if(user!=null){
            if (userRepo.existsByEmail(user.getEmail())) {
                throw new UserAlreadyExistsException("Email already exists");
            }
            if(userRepo.existsByUsername(user.getUsername())){
                throw new UserAlreadyExistsException("Username already exists");
            }
            userRepo.save(user);
        }
    }
    public void Login(LoginDto loginDto) {
        User user = LoginMapper.mapToUser(loginDto,new User());
        Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
       if(existingUser.isPresent()){
           String password = userRepo.findPasswordByEmail(user.getEmail());
           if(user.getPassword().equals(password)){
           }
           else throw new LoginFailedException("Login Failed");
       }

    }

    public UserDetailsDto getUserDetailsById(int id){
        return userRepo.findById(id) // Find the user by ID
                .map(user -> new UserDetailsDto(
                        user.getEmail(),
                        user.getName(),
                        user.getUsername()
                )) // Map User to UserDetailsDto
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID " + id)); // Handle missing user

    }

    public List<UserDetailsDto> getUserDetailsByIds(List<Integer> ids) {
        return  userRepo.findByIdIn(ids)
                .stream()
                .map(user -> new UserDetailsDto(
                        user.getEmail(),
                        user.getName(),
                        user.getUsername()
                ))
                .toList();
    }
}
