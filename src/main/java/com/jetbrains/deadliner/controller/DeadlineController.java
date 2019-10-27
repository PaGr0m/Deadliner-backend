package com.jetbrains.deadliner.controller;

import com.jetbrains.deadliner.model.Deadline;
import com.jetbrains.deadliner.service.DeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("deadlines")
public class DeadlineController {

    private final DeadlineService deadlineService;

    @Autowired
    public DeadlineController(DeadlineService deadlineService) {
        this.deadlineService = deadlineService;
    }

    // TODO: убрать "привет мир"
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/create")
    public Deadline create(@RequestBody Deadline deadline) {
        return deadlineService.create(deadline);
    }

    @GetMapping("/{id}")
    public Deadline get(@PathVariable("id") UUID deadlineId) {
        return deadlineService.getExist(deadlineId);
    }

    @GetMapping("/list")
    public Page<Deadline> list(Pageable pageable) {
        return deadlineService.findAll(pageable);
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID deadlineId) {
        return deadlineService.delete(deadlineId);
    }


//    @GetMapping("list")
//    public CollectionDTO<ReportDto> list(@RequestParam(required = false) String formId) {
//        return MapperUtils.getCollectionMapper(reportMapper::toDto)
//                          .compose(reportService::list)
//                          .apply(ListReportArgument.builder()
//                                                   .formId(formId)
//                                                   .build());
//    }
}