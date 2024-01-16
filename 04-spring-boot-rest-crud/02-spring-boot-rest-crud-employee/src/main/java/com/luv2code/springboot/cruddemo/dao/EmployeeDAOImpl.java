package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    // define field for entityManager
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {

        // crete a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        // return list
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        // get employee
        // return employee
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
