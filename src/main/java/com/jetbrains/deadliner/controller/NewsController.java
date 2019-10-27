package com.jetbrains.deadliner.controller;


import com.jetbrains.deadliner.model.News;
import com.jetbrains.deadliner.service.NewsService;
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

    @PostMapping("/create")
    public News create(@RequestBody News news) {
        return newsService.create(news);
    }

    @GetMapping("/{id}")
    public News get(@PathVariable("id") UUID newsId) {
        return newsService.getExist(newsId);
    }

    @GetMapping("/list")
    public Page<News> list(Pageable pageable) {
        return newsService.findAll(pageable);
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") UUID newsId) {
        return newsService.delete(newsId);
    }
}
