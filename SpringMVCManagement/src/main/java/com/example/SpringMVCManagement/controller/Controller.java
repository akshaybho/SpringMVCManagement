package com.example.SpringMVCManagement.controller;


import com.example.SpringMVCManagement.entity.Student;
import com.example.SpringMVCManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private StudentService stdService;

    @GetMapping("/home")
    public String home()
    {
        return "home"; // view page html file -> home.html
    }

    @GetMapping("/students")
    public String getAllData(Model model)
    {
        model.addAttribute("students", stdService.getAllStudents());

        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {

        Student std = new Student();
        model.addAttribute("student", std);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student std)
    {
        stdService.savStudent(std);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model)
    {
        model.addAttribute("student", stdService.getById(id));

        return "edit_student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student)
    {
        Student existStudent = stdService.getById(id);

        existStudent.setFirstName(student.getFirstName());
        existStudent.setLastName(student.getLastName());
        existStudent.setEmail(student.getEmail());

        stdService.savStudent(existStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id)
    {
        stdService.deleteById(id);
        return "redirect:/students";
    }
}
