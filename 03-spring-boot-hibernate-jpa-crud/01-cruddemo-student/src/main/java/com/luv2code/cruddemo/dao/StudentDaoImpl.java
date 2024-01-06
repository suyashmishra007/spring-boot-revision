package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Support Component Scanning
// Translate JDBC Exceptions.
@Repository
public class StudentDaoImpl implements StudentDao {

  // Define field for entity manager.
  private EntityManager entityManager;

  // inject entity manager using constructor injection.
  @Autowired
  public StudentDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  // implement save method.
  @Override
  @Transactional
  public void save(Student theStudent) {
    entityManager.persist(theStudent);
  }
}
