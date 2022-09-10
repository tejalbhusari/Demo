package com.example.practise.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentData = studentRepo.findStudentByEmail(student.getEmail());
        System.out.println(studentData);
        if (!studentData.isPresent()){
            Student s1 = studentRepo.save(student);
            System.out.println("data is " + s1);
        }
    }

}
