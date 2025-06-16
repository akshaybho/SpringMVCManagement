package com.example.SpringMVCManagement.service;

import com.example.SpringMVCManagement.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student savStudent(Student std);

    public Student getById(int id);

    public void deleteById(int id);

}
