package com.jetbrains.deadliner.service.impl;

import com.jetbrains.deadliner.exception.EntityNotFoundException;
import com.jetbrains.deadliner.model.Subject;
import com.jetbrains.deadliner.repository.SubjectRepository;
import com.jetbrains.deadliner.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(
                Subject.builder()
                       .name(subject.getName())
                       .build());
    }

    @Override
    @Transactional(readOnly = true)
    public Subject getExist(UUID subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        if (subject.isPresent())
            return subject.get();
        else
            throw new EntityNotFoundException(Subject.class, "Subject not found");
    }

    @Override
    @Transactional(readOnly = true)
    public Subject getByName(String subjectName) {
        Optional<Subject> subject = subjectRepository.getByName(subjectName);

        if (subject.isPresent())
            return subject.get();
        else
            throw new EntityNotFoundException(Subject.class, "Subject not found");
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @Override
    public String delete(UUID subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        if (subject.isPresent())
            subjectRepository.delete(subject.get());
        else
            throw new EntityNotFoundException(Subject.class, "Subject not found");

        return "Subject with ID <" + subjectId + "> was deleted !";
    }
}
