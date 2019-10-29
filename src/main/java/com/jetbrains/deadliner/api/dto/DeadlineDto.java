package com.jetbrains.deadliner.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeadlineDto {

    @NotNull
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime dateTimeStart;

    @NotNull
    private LocalDateTime dateTimeFinish;

    @NotNull
    private String subjectName;
}
