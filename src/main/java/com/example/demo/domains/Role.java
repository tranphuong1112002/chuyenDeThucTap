package com.example.demo.domains;

import com.example.demo.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
 
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_generator")
  @SequenceGenerator(name = "role_generator", sequenceName = "role_seq", initialValue = 3, allocationSize = 1)
  @Column(name = "id")
  private int id;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private RoleEnum role;

  @ManyToMany(mappedBy = "roles")
  @JsonIgnore
  private Set<User> users;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "role_permissions",
      joinColumns = @JoinColumn(name = "role_id"),
      inverseJoinColumns = @JoinColumn(name = "permission_id"))
  private Set<Permission> permissions;
}
