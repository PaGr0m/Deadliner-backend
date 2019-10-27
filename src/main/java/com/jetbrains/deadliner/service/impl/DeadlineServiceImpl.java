package com.jetbrains.deadliner.service.impl;

import com.jetbrains.deadliner.exception.EntityNotFoundException;
import com.jetbrains.deadliner.model.Deadline;
import com.jetbrains.deadliner.repository.DeadlineRepository;
import com.jetbrains.deadliner.service.DeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeadlineServiceImpl implements DeadlineService {

    private final DeadlineRepository deadlineRepository;

    @Autowired
    public DeadlineServiceImpl(DeadlineRepository deadlineRepository) {
        this.deadlineRepository = deadlineRepository;
    }

    @Override
    @Transactional
    public Deadline create(Deadline deadline) {
        return deadlineRepository.save(Deadline.builder()
                                               .name(deadline.getName())
                                               .description(deadline.getDescription())
                                               .dateTimeStart(deadline.getDateTimeStart())
                                               .dateTimeFinish(deadline.getDateTimeFinish())
                                               .build());
    }

    @Override
    @Transactional(readOnly = true)
    public Deadline getExist(UUID uuid) {
        Optional<Deadline> deadline = deadlineRepository.findById(uuid);
        if (deadline.isPresent())
            return deadline.get();
        else
            throw new EntityNotFoundException(Deadline.class, "Deadline not found");
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Deadline> findAll(Pageable pageable) {
        return deadlineRepository.findAll(pageable);
    }

    @Override
    public String delete(UUID deadlineId) {
        Optional<Deadline> deadline = deadlineRepository.findById(deadlineId);

        if (deadline.isPresent())
            deadlineRepository.delete(deadline.get());
        else
            throw new EntityNotFoundException(Deadline.class, "Deadline not found");

        return "Deadline with ID <" + deadlineId + "> was deleted !";
    }
}
