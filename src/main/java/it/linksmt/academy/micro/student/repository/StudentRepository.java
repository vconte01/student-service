package it.linksmt.academy.micro.student.repository;

import it.linksmt.academy.micro.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



}
