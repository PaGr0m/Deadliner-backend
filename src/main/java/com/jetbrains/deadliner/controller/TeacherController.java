package com.jetbrains.deadliner.controller;

import com.jetbrains.deadliner.model.Teacher;
import com.jetbrains.deadliner.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.create(teacher);
    }

    @GetMapping("/{id}")
    public Teacher get(@PathVariable("id") UUID teacherId) {
        return teacherService.getExist(teacherId);
    }

    @GetMapping("/list")
    public Page<Teacher> list(Pageable pageable) {
        return teacherService.findAll(pageable);
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID teacherId) {
        return teacherService.delete(teacherId);
    }
}
