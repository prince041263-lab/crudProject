package org.example.crudproject.Controller;

import jakarta.validation.Valid;
import org.example.crudproject.DTO.StudentRequestDto;
import org.example.crudproject.DTO.StudentResponseDto;
import org.example.crudproject.DTO.UpdateStudentRequestDto;
import org.example.crudproject.DTO.UpdateStudentResponseDto;
import org.example.crudproject.Service.StudentService;
import org.example.crudproject.Entity.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

    StudentService studentService;

    StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> CreateStudent(
            @Valid @RequestBody StudentRequestDto studentRequestDto){ //service class will perform business logic for this
        StudentResponseDto CreatedStudent = studentService.CreateStudent(studentRequestDto);
        return ResponseEntity.ok(CreatedStudent);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Students> ReadStudent(@PathVariable Long Id){
        Students  studentResp = studentService.getStudent(Id);
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping
    public ResponseEntity<List<Students>> ReadAllStudent(){
        List<Students>  studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponseDto> UpdateStudent(@PathVariable Long id,
                                                                  @Valid @RequestBody UpdateStudentRequestDto students){
        UpdateStudentResponseDto updatedstudent = studentService.updateStudent(id, students);

            return ResponseEntity.ok(updatedstudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
        studentService.softDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
