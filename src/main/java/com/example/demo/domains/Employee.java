package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.*;

@Entity
 
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "employee_code")
  private String employeeCode;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "job_title")
  private String jobTitle;

  @Column(name = "department")
  private String department;

  @Column(name = "employee_index")
  private Integer employeeIndex;


  public String getFullName() {
    return this.lastName + " " + this.firstName;
  }
}
