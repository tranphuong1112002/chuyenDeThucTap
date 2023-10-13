package com.example.demo.services;

import com.example.demo.domains.User;
import com.example.demo.dtos.users.UserLoginRequestDTO;
import com.example.demo.dtos.users.UserRequestDTO;
import com.example.demo.dtos.users.UserResponseDTO;

public interface UserService {

    void signUp(UserRequestDTO dto);

    UserResponseDTO signUp(UserLoginRequestDTO dto);

    User getUserInfo();
}
