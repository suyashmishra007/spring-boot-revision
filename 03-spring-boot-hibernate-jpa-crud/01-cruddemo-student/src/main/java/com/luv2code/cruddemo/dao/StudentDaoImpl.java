package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Support Component Scanning
// Translate JDBC Exceptions.
@Repository
public class StudentDaoImpl implements StudentDao {

  // Define field for entity manager.
  private final EntityManager entityManager;

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

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class,id);
  }

  @Override
  public List<Student> findAll() {
    // create query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

    // return query results
    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastName(String theLastName) {
    // create query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student Where lastName=:theData",Student.class);

    //set query parameter
    theQuery.setParameter("theData",theLastName);

    // return query list
    return  theQuery.getResultList();
  }

  @Override
  @Transactional // since we are performing update in DB.
  public void update(Student theStudent) {
    entityManager.merge(theStudent);
  }

  @Override
  @Transactional
  public void deleteById(Integer id) {
    Student theStudent = entityManager.find(Student.class,id);
    entityManager.remove(theStudent);
  }
  @Override
  @Transactional
  public int deleteAll() {
      return entityManager.createQuery("DELETE FROM Student").executeUpdate();
  }
}
