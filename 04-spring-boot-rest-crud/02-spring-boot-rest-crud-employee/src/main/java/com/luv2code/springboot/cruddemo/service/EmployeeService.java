package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);

}
/*
    Service Layer : Best Practice
    -> Apply Transactional boundaries at the service layer.
    -> It is the service layer's responsibilitity to manage transactions boundaries.
    -> For code implementation,
        * Apply @Transactional on serive method.
        * Remove @Trasactonal on DAO methods if they already exits.
*/