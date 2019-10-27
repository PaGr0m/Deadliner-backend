package com.jetbrains.deadliner.service;

import com.jetbrains.deadliner.model.Deadline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface DeadlineService {
    Deadline create(Deadline deadline);

    Deadline getExist(UUID deadlineId);

    Page<Deadline> findAll(Pageable pageable);

    String delete(UUID deadlineId);
}
