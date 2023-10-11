package com.example.demo.controllers;

import com.example.demo.dtos.users.UserLoginRequestDTO;
import com.example.demo.dtos.users.UserRequestDTO;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<?> signUp(@RequestBody @Valid UserRequestDTO dto) {
    userService.signIn(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/signin")
  public ResponseEntity<?> signIn(@RequestBody @Valid UserLoginRequestDTO dto) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.signIn(dto));
  }

  @GetMapping("/test")
  public ResponseEntity<?> test() {
    return ResponseEntity.status(HttpStatus.OK).body("dljflsdkjdlas");
  }
}
