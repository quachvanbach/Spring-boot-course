package com.example.spring.studentmanagementmvc.rest;

import com.example.spring.studentmanagementmvc.entity.Student;
import com.example.spring.studentmanagementmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "/student/students";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/student-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) {
            studentService.addStudent(student); // Cập nhật sinh viên
        }else{
                studentService.updateStudent(student); // Cập nhật sinh viên}
            }
            return "redirect:/students/list";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "/student/student-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }
}