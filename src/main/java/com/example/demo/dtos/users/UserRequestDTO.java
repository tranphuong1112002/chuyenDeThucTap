package com.example.demo.dtos.users;

import com.example.demo.enums.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

  @NotBlank(message = "Tài khoản không được để trống")
  @Size(max = 50)
  private String username;

  @NotBlank(message = "Mật khẩu không được để trống")
  @Size(min = 6, max = 40)
  private String password;

  private Set<RoleEnum> roles;
}
