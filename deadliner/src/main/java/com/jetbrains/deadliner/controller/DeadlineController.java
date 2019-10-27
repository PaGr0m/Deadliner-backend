package com.jetbrains.deadliner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("deadlines")
public class DeadlineController {

    @GetMapping("hello")
    public String hello() {
        return "Hello world";
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
