package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDao studentDao) {
    return runner -> {
//      createStudent(studentDao);
      createMuttipleStudents(studentDao);
//      readStudent(studentDao);
//      queryForStudents(studentDao);
//      queryForStudentsByLastName(studentDao);
//      updateStudent(studentDao);
//      deleteStudent(studentDao);
//      deleteAllStudents(studentDao);
    };
    
  }

  private void deleteAllStudents(StudentDao studentDao) {
    System.out.println("Nums of Rows Delete : " + studentDao.deleteAll());
  }

  private void deleteStudent(StudentDao studentDao) {
    int studentId = 5 ;
    System.out.println("Deleting student with id "+ studentId);
    studentDao.deleteById(studentId);
  }

  private void updateStudent(StudentDao studentDao) {

    int studentId = 1;
    // retrieve student based on the id : primary key
    Student student = studentDao.findById(studentId);
    System.out.println("student with id 1 : " + student);

    // Change first name to "Maxwell"
    student.setFirstName("Maxwell");

    // update the student
    studentDao.update(student);
    System.out.println("Updated student " + student);
  }

  private void queryForStudentsByLastName(StudentDao studentDao) {

    List<Student> studentList= studentDao.findByLastName("Doe");

    for(Student student : studentList){
      System.out.println(student);
    }
  }

  private void queryForStudents(StudentDao studentDao) {
    // get a list of students.
    List < Student > theStudents = studentDao.findAll();

    // display the list of students.
    for (Student tempStudent: theStudents) {
      System.out.println(tempStudent);
    }
  }

  private void readStudent(StudentDao studentDao) {

    // crete a student object.
    System.out.println("Creating a new student");
    Student tempStudent = new Student("daffy", "Duck", "dd@gmail.com");

    // save the student object.
    System.out.println("Saving student object..");
    studentDao.save(tempStudent);

    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());

    // retrieve  student based on the id: Primary key.
    Student myStudent = studentDao.findById(tempStudent.getId());

    System.out.println("Found the student " + myStudent);
  }

  private void createMuttipleStudents(StudentDao studentDao) {

    // create multiple student
    System.out.println("Creating 3 new students object..");
    Student student1 = new Student("John", "Doe", "jd@gmail.com");
    Student student2 = new Student("Jack ", "Ryan", "jr@gmail.com");
    Student student3 = new Student("Mary", "Public", "mp@gmail.com");

    // save the student object
    System.out.println("Saving out student objects...");
    studentDao.save(student1);
    studentDao.save(student2);
    studentDao.save(student3);

  }

  private void createStudent(StudentDao studentDao) {
    // create the student object
    Student student = new Student("Suyash","Mishra","Sm@gmail.com");

    // save the student object
    System.out.println("Saving out student object...");
    studentDao.save(student);

    // display id of the saved student
    System.out.println("Saved student. Generated id: " + student.getId());

  }
}