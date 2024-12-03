package com.example.BlogsandComments.service;



import com.example.BlogsandComments.DTO.LoginDto;
import com.example.BlogsandComments.models.User;

import java.util.Optional;

public interface IUserService {

    void registration(User user);
    void login(LoginDto loginDto);



}
