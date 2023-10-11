package com.example.demo.repositories;

import com.example.demo.domains.Role;
import com.example.demo.enums.RoleEnum;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByRole(RoleEnum role);

  Set<Role> findAllByRoleIn(Set<RoleEnum> roles);
}
