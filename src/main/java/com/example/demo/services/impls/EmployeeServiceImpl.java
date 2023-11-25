package com.example.demo.services.impls;

import com.example.demo.domains.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id);
    }

  @Override
  public void createEmployee(Employee dto) {
    Integer maxIndex = employeeRepository.findMaxIndex();
    if (maxIndex == null) {
      maxIndex = 0;
    }
    int newIndex = maxIndex + 1;
    String employeeCode = "NV" + String.format("%05d", newIndex);
    Employee newEmp = Employee.builder()
        .firstName(dto.getFirstName())
        .lastName(dto.getLastName())
        .employeeCode(employeeCode)
        .jobTitle(dto.getJobTitle())
        .department(dto.getDepartment())
        .employeeIndex(newIndex)
        .build();
    employeeRepository.save(newEmp);
  }
}
