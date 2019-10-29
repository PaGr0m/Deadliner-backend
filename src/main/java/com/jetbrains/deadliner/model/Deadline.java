package com.jetbrains.deadliner.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deadline")
public class Deadline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time_start")
    private LocalDateTime dateTimeStart;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time_finish")
    private LocalDateTime dateTimeFinish;

    @Column(name = "subject")
    private String subject;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
//    private Subject subject;
}
