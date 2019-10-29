package com.jetbrains.deadliner.action;

import com.jetbrains.deadliner.api.dto.DeadlineDto;
import com.jetbrains.deadliner.model.Deadline;
import com.jetbrains.deadliner.service.DeadlineService;
import com.jetbrains.deadliner.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeadlineCreateAction {

    private final DeadlineService deadlineService;
    private final SubjectService subjectService;

    @Autowired
    public DeadlineCreateAction(DeadlineService deadlineService, SubjectService subjectService) {
        this.deadlineService = deadlineService;
        this.subjectService = subjectService;
    }

    @Transactional
    public Deadline create(DeadlineDto deadlineDto) {
        return deadlineService.create(
                Deadline.builder()
                        .name(deadlineDto.getName())
                        .description(deadlineDto.getDescription())
                        .dateTimeStart(deadlineDto.getDateTimeStart())
                        .dateTimeFinish(deadlineDto.getDateTimeFinish())
                        .subject(subjectService.getByName(deadlineDto.getSubjectName()))
                        .build());
    }
}
