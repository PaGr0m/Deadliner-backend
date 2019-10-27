package com.jetbrains.deadliner.api.controller;

import com.jetbrains.deadliner.model.Subject;
import com.jetbrains.deadliner.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @ApiOperation("Создать предмет обучения")
    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject) {
        return subjectService.create(subject);
    }

    @ApiOperation("Получить предмет по идентификатору")
    @GetMapping("/{id}")
    public Subject get(@PathVariable("id") UUID subjectId) {
        return subjectService.getExist(subjectId);
    }

    @ApiOperation("Получить предмет по названию")
    @GetMapping("/{subjectName}")
    public Subject getByName(@PathVariable("subjectName") String subjectName) {
        return subjectService.getByName(subjectName);
    }

    @ApiOperation("Получить список предметов")
    @GetMapping("/list")
    public Page<Subject> list(Pageable pageable) {
        return subjectService.findAll(pageable);
    }

    @ApiOperation("Удалить предмет по идентификатору")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID subjectId) {
        return subjectService.delete(subjectId);
    }
}
