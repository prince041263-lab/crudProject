package org.example.crudproject.Service;

import org.example.crudproject.DTO.StudentRequestDto;
import org.example.crudproject.DTO.StudentResponseDto;
import org.example.crudproject.DTO.UpdateStudentRequestDto;
import org.example.crudproject.DTO.UpdateStudentResponseDto;
import org.example.crudproject.Entity.Students;
import org.example.crudproject.Repository.StudentRepo;
import org.example.crudproject.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepo studentRepo;

    StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentResponseDto CreateStudent(StudentRequestDto studentReq) {
        Students studentEntity = MapToEntity(studentReq);
        Students student = studentRepo.save(studentEntity);
        return MapToDto(student);
    }

    public Students getStudent(Long id) {
        Students student =
                studentRepo.findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" Not found"));
        return student;
    }

    public List<Students> getAllStudent() {
        List<Students> studentList = studentRepo.findByDeletedIsFalse();
        return studentList;
    }


    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentreq) {
        Students StudentToSave =
                studentRepo.findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" Not found"));

        StudentToSave.setAge(studentreq.getAge());
        StudentToSave.setCourse(studentreq.getCourse());
        //StudentToSave.setEmail(studentreq.getEmail());
        StudentToSave.setName(studentreq.getName());
        StudentToSave.setRollNo(studentreq.getRollNo());

        Students savedStudent = studentRepo.save(StudentToSave);
        return MapToUpdatedDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        Students StudentToBeDeleted =
                studentRepo.findById(id)
                        .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" Not found"));

        studentRepo.delete(StudentToBeDeleted);
    }

    public void softDelete(Long id) {
        Students StudentToBeDeleted =
                studentRepo.findByIdAndDeletedIsFalse(id)
                        .orElseThrow(()->new ResourceNotFoundException("Student with id "+id+" Not found"));

        StudentToBeDeleted.setDeleted(true);
        studentRepo.save(StudentToBeDeleted);
    }

    private Students MapToEntity(StudentRequestDto studentRequestDto) {
        Students student = new Students();
        student.setName(studentRequestDto.getName());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setEmail(studentRequestDto.getEmail());
        student.setCourse(studentRequestDto.getCourse());
        student.setAge(studentRequestDto.getAge());
        student.setDeleted(false);
        return student;
    }

    private StudentResponseDto MapToDto(Students student) {

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setCourse(student.getCourse());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMessage("process happens successfully");
        return studentResponseDto;
    }

    private UpdateStudentResponseDto MapToUpdatedDto(Students student) {

        UpdateStudentResponseDto studentResponseDto = new UpdateStudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setCourse(student.getCourse());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMessage("student  updated successfully");
        return studentResponseDto;
    }

}
