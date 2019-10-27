package com.jetbrains.deadliner.service;

import com.jetbrains.deadliner.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface SubjectService {
    Subject create(Subject subject);

    Subject getExist(UUID subjectId);

    Subject getByName(String subjectName);

    Page<Subject> findAll(Pageable pageable);

    String delete(UUID subjectId);
}
