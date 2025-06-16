package com.example.SpringMVCManagement.service;

import com.example.SpringMVCManagement.entity.Student;
import com.example.SpringMVCManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
    StudentRepository stdRepo;

    @Override
    public List<Student> getAllStudents() {

        List <Student> list =  stdRepo.findAll();

        return list;
    }

    @Override
    public Student savStudent(Student std) {

        return stdRepo.save(std);
    }

    @Override
    public Student getById(int id) {

        return stdRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {

        stdRepo.deleteById(id);
    }
}
