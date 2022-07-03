package it.linksmt.academy.micro.student.service;

import it.linksmt.academy.micro.student.exception.StudentNotFoundException;
import it.linksmt.academy.micro.student.model.Student;
import it.linksmt.academy.micro.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow( () -> new StudentNotFoundException("Not Found id "+id));
    }

    @Override
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {

        return studentRepository.findById(student.getId())
                .map( s -> {
                    s.setName(student.getName());
                    s.setSurname(student.getSurname());
                    return studentRepository.save(s);
                })
                .orElseThrow(() -> new StudentNotFoundException("Not found ID: "+student.getId()));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
