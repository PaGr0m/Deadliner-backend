package com.jetbrains.deadliner.controller;

import com.jetbrains.deadliner.model.Subject;
import com.jetbrains.deadliner.service.SubjectService;
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

    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject) {
        return subjectService.create(subject);
    }

    @GetMapping("/{id}")
    public Subject get(@PathVariable("id") UUID subjectId) {
        return subjectService.getExist(subjectId);
    }

    @GetMapping("/list")
    public Page<Subject> list(Pageable pageable) {
        return subjectService.findAll(pageable);
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID subjectId) {
        return subjectService.delete(subjectId);
    }
}
