package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
