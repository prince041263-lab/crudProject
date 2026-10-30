package org.example.crudproject.Controller;

import org.example.crudproject.Service.StudentService;
import org.example.crudproject.Entity.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
        return ResponseEntity.ok(CreatedStudent);
    }

    @GetMapping("/get/{Id}")
    public ResponseEntity<Students> ReadStudent(@PathVariable Long Id){
        Students  studentResp = studentService.getStudent(Id);
        if(studentResp == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Students>> ReadAllStudent(){
        List<Students>  studentList = studentService.getAllStudent();
        if(studentList == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Students> UpdateStudent(@PathVariable Long id,
                                                    @RequestBody Students students){
            Students updatedstudent = studentService.updateStudent(id, students);
            if(updatedstudent == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.ok(updatedstudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteStudent(@PathVariable Long id){
        Boolean isdeleted = studentService.deleteStudent(id);
        if(!isdeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record deleted successfully");

    }
}
