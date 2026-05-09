package com.example.md4session8.controllers;

import com.example.md4session8.exceptions.StudentNotFoundException;
import com.example.md4session8.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    List<Student> students = new ArrayList<>();

    //Giả lập danh sách
    public StudentController() {
        students.add(new Student("SV001", "Nguyễn Văn A"));
        students.add(new Student("SV002", "Trần Thị B"));
        students.add(new Student("SV003", "Phan Thanh C"));
        students.add(new Student("SV004", "Bùi Minh D"));
        students.add(new Student("SV005", "Nguyễn Xuân E"));
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Sinh viên có ID " + id + " không tồn tại");
    }
}
