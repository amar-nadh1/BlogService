package com.example.BlogsandComments.MapperClass;


import com.example.BlogsandComments.DTO.LoginDto;
import com.example.BlogsandComments.models.User;

public class LoginMapper {
    public static User mapToUser(LoginDto loginDto, User user){
        user.setEmail(loginDto.getEmail());
        user.setPassword(loginDto.getPassword());
        return user;
    }
}
