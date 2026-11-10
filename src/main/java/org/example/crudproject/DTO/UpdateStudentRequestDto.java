package org.example.crudproject.DTO;

import jakarta.validation.constraints.NotBlank;

public class UpdateStudentRequestDto {
    private Long Id;

    @NotBlank
    private String name;
    private int age;
    //private String email;
    private int rollNo;
    private String Course;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
