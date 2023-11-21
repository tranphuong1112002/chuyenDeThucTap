package com.example.demo.services.impls;

import com.example.demo.domains.Role;
import com.example.demo.domains.User;
import com.example.demo.dtos.users.UserLoginRequestDTO;
import com.example.demo.dtos.users.UserRequestDTO;
import com.example.demo.dtos.users.UserResponseDTO;
import com.example.demo.enums.RoleEnum;
import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.RCException;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import com.example.demo.services.UserService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder encoder;
  private final JwtUtils jwtUtils;

  @Override
  public void signUp(UserRequestDTO dto) {
    if (userRepository.existsByUsername(dto.getUsername())) {
      throw new RCException(ExceptionUtils.E_USERNAME_EXISTED);
    }
    if (dto.getRoles() != null) {
      Set<Role> roles = roleRepository.findAllByRoleIn(dto.getRoles());
      User user =
          User.builder()
              .username(dto.getUsername())
              .password(encoder.encode(dto.getPassword()))
              .roles(roles)
              .build();
      userRepository.save(user);
    } else {
      User user =
          User.builder()
              .username(dto.getUsername())
              .password(encoder.encode(dto.getPassword()))
              .candidateId(dto.getCandidateId())
              .build();
      userRepository.save(user);
    }
  }

  @Override
  public UserResponseDTO signUp(UserLoginRequestDTO dto) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    Set<String> roles =
        userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toSet());
    Map<String, RoleEnum> roleMap = new HashMap<>();
    roleMap.put("ADMIN", RoleEnum.ADMIN);
    roleMap.put("HR", RoleEnum.HR);
    roleMap.put("CANDIDATE", RoleEnum.CANDIDATE);
    Set<RoleEnum> roleEnums = roles.stream().map(roleMap::get).collect(Collectors.toSet());
    Set<Role> roleSet = roleRepository.findAllByRoleIn(roleEnums);
    return new UserResponseDTO(jwt, userDetails.getUsername(), roleSet);
  }

  @Override
  public User getUserInfo() {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = userRepository.findByUsername(username).get();
    return user;
  }
}
