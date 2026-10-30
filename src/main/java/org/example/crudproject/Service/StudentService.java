package org.example.crudproject.Service;

import org.example.crudproject.Entity.Students;
import org.example.crudproject.Repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepo studentRepo;

    StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public Students CreateStudent(Students studentReq){
        Students studentreq = studentRepo.save(studentReq);
        return studentreq;
    }
}
