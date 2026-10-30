package org.example.crudproject.Controller;

import org.example.crudproject.Service.StudentService;
import org.example.crudproject.Entity.Students;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Students> CreateStudent(@RequestBody Students students){ //service class will perform business logic for this
        Students CreatedStudent = studentService.CreateStudent(students);
        return ResponseEntity.accepted().body(CreatedStudent);
    }
    public void ReadStudent(){

    }
    public void UpdateStudent(){

    }
    public void DeleteStudent(){

    }
}
