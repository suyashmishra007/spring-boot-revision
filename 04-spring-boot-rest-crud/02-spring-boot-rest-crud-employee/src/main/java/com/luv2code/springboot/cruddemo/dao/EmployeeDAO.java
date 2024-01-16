package com.luv2code.springboot.cruddemo.dao;
import java.util.List;
import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
