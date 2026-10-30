package org.example.crudproject.Controller;

import org.example.crudproject.Service.StudentService;
import org.example.crudproject.Service.Students;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

    StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public void CreateStudent(@RequestBody Students students){ //service class will perform business logic for this
        Students CreatedStudent = studentService.CreateStudent(students);
    }
    public void ReadStudent(){

    }
    public void UpdateStudent(){

    }
    public void DeleteStudent(){

    }
}
