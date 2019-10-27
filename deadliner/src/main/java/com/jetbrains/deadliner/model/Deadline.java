package com.jetbrains.deadliner.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Deadline {

    private String description;

    private LocalDateTime dateTimeStart;

    private LocalDateTime dateTimeFinish;
}
