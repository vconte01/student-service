package it.linksmt.academy.micro.student.service;

import it.linksmt.academy.micro.student.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student getStudent(Long id);

    Student insert(Student student);

    Student update(Student student);

    void delete(Long id);
}
