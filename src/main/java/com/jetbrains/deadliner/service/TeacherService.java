package com.jetbrains.deadliner.service;

import com.jetbrains.deadliner.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TeacherService {
    Teacher create(Teacher teacher);

    Teacher getExist(UUID teacherId);

    Page<Teacher> findAll(Pageable pageable);

    String delete(UUID teacherId);
}
