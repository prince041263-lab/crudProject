package org.example.crudproject.Service;

import org.example.crudproject.Entity.Students;
import org.example.crudproject.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Students getStudent(Long id){
        Optional<Students> studentresp = studentRepo.findById(id);
        if(studentresp.isPresent()) return studentresp.get();
        else return null;
    }
    public List<Students> getAllStudent(){
        List<Students> studentList = studentRepo.findAll();
        return studentList;
    }


    public Students updateStudent(Long id, Students studentreq){
        Optional<Students> existingStudent = studentRepo.findById(id);

        if(existingStudent.isEmpty()) return null;

        Students StudentToSave = existingStudent.get();

        StudentToSave.setAge(studentreq.getAge());
        StudentToSave.setCourse(studentreq.getCourse());
        StudentToSave.setEmail(studentreq.getEmail());
        StudentToSave.setName(studentreq.getName());
        StudentToSave.setRollNo(studentreq.getRollNo());

        return studentRepo.save(StudentToSave);
    }

    public  Boolean deleteStudent(Long id){
        Boolean exitence = studentRepo.existsById(id);
        if(!exitence) return false;
//        studentRepo.delete(studentRepo.findById(id).get());
        studentRepo.deleteById(id);
        return true;
    }
}
