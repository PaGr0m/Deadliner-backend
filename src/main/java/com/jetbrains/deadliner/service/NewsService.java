package com.jetbrains.deadliner.service;

import com.jetbrains.deadliner.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NewsService {
    News create(News news);

    News getExist(UUID newsId);

    Page<News> findAll(Pageable pageable);

    String delete(UUID newsId);
}
