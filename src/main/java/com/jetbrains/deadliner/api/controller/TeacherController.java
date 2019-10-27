package com.jetbrains.deadliner.api.controller;

import com.jetbrains.deadliner.model.Teacher;
import com.jetbrains.deadliner.service.TeacherService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("Создать преподавателя")
    @PostMapping("/create")
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.create(teacher);
    }

    @ApiOperation("Получить преподавателя по идентификатору")
    @GetMapping("/{id}")
    public Teacher get(@PathVariable("id") UUID teacherId) {
        return teacherService.getExist(teacherId);
    }

    @ApiOperation("Получить список преподавателей")
    @GetMapping("/list")
    public Page<Teacher> list(Pageable pageable) {
        return teacherService.findAll(pageable);
    }

    @ApiOperation("Удалить преподавателя по идентификатору")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID teacherId) {
        return teacherService.delete(teacherId);
    }
}
