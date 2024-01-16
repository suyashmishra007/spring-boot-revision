package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    // quick and dirty : inject employee DAO.
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }

    // expose the '/employees' nad return a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable  int id){
         Employee employee = employeeService.findById(id);
         if(employee == null){
             throw  new RuntimeException("Employee id not found - " + id);
         }
         return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee theEmployee){
        // just also in case they pass an id in JSON , set id to '0'
        // this is to focus a save of new item ... instead of update
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
    }
}
