package com.example.demo.domains;

import com.example.demo.enums.PermissionEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
 
@Table(name = "permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissions_generator")
    @SequenceGenerator(name = "permissions_generator", sequenceName = "permissions_seq", initialValue = 9, allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "permission")
    @Enumerated(EnumType.STRING)
    private PermissionEnum permission;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles;
}
