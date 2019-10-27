package com.jetbrains.deadliner.service.impl;

import com.jetbrains.deadliner.exception.EntityNotFoundException;
import com.jetbrains.deadliner.model.Teacher;
import com.jetbrains.deadliner.repository.TeacherRepository;
import com.jetbrains.deadliner.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(
                Teacher.builder()
                       .fio(teacher.getFio())
                       .email(teacher.getEmail())
                       .contact(teacher.getContact())
                       .build());
    }

    @Override
    public Teacher getExist(UUID teacherId) {
        Optional<Teacher> subject = teacherRepository.findById(teacherId);

        if (subject.isPresent())
            return subject.get();
        else
            throw new EntityNotFoundException(Teacher.class, "Teacher not found");
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public String delete(UUID teacherId) {
        Optional<Teacher> subject = teacherRepository.findById(teacherId);

        if (subject.isPresent())
            teacherRepository.delete(subject.get());
        else
            throw new EntityNotFoundException(Teacher.class, "Teacher not found");

        return "Teacher with ID <" + teacherId + "> was deleted !";
    }
}
