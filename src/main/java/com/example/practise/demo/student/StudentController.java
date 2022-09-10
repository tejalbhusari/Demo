package com.example.practise.demo.student;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully response json"),
        @ApiResponse(code = 400, message = "Only content type application/json is accepted"),
        @ApiResponse(code = 401, message = "Authentication Failed"),
        @ApiResponse(code = 500, message = "Internal Server Error"),
})
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "add student ", response = Student.class)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }


}
