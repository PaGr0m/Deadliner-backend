package com.jetbrains.deadliner.api.controller;


import com.jetbrains.deadliner.model.News;
import com.jetbrains.deadliner.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ApiOperation("Создать новость")
    @PostMapping("/create")
    public News create(@RequestBody News news) {
        return newsService.create(news);
    }

    @ApiOperation("Получить новость по идентификатору")
    @GetMapping("/{id}")
    public News get(@PathVariable("id") UUID newsId) {
        return newsService.getExist(newsId);
    }

    @ApiOperation("Получить список новостей")
    @GetMapping("/list")
    public Page<News> list(Pageable pageable) {
        return newsService.findAll(pageable);
    }

    @ApiOperation("Удалить новость по идентификатору")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID newsId) {
        return newsService.delete(newsId);
    }
}
