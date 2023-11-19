package com.example.demo.controllers;

import com.example.demo.dtos.users.UserLoginRequestDTO;
import com.example.demo.dtos.users.UserRequestDTO;
import com.example.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "Đăng ký, đăng nhập, thêm sửa xoá role")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  @Operation(summary = "ADMIN - Đăng ký tài khoản cho khách hàng")
  @ApiResponse(responseCode = "201", description = "Tài khoản được đăng ký thành công")
  @PostMapping("/signup")
  public ResponseEntity<?> signUp(@RequestBody @Valid UserRequestDTO dto) {
    userService.signUp(dto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/signin")
  public ResponseEntity<?> signIn(@RequestBody @Valid UserLoginRequestDTO dto) {
    return ResponseEntity.status(HttpStatus.OK).body(userService.signUp(dto));
  }

  @GetMapping("/me")
  public ResponseEntity<?> test() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfo());
  }
}
