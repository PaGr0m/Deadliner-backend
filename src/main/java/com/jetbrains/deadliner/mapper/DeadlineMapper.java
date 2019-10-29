package com.jetbrains.deadliner.mapper;

import com.jetbrains.deadliner.api.dto.DeadlineCreateDto;
import com.jetbrains.deadliner.model.Deadline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface DeadlineMapper {

    @Mappings({
        @Mapping(source = "deadline.id", target = "id"),
        @Mapping(source = "subject.name", target = "subjectName")})
    DeadlineCreateDto toDeadlineDto(Deadline deadline);
}
