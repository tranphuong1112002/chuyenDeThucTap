package com.example.demo.services;

import com.example.demo.dtos.users.UserLoginRequestDTO;
import com.example.demo.dtos.users.UserRequestDTO;
import com.example.demo.dtos.users.UserResponseDTO;

public interface UserService {

    void signIn(UserRequestDTO dto);

    UserResponseDTO signIn(UserLoginRequestDTO dto);
}
