package com.jetbrains.deadliner.service.impl;

import com.jetbrains.deadliner.exception.EntityNotFoundException;
import com.jetbrains.deadliner.model.News;
import com.jetbrains.deadliner.repository.NewsRepository;
import com.jetbrains.deadliner.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News create(News news) {
        return newsRepository.save(News.builder()
                                       .description(news.getDescription())
                                       .dateTimeStart(news.getDateTimeStart())
                                       .dateTimeFinish(news.getDateTimeFinish())
                                       .build());
    }

    @Override
    public News getExist(UUID newsId) {
        Optional<News> news = newsRepository.findById(newsId);

        if (news.isPresent())
            return news.get();
        else
            throw new EntityNotFoundException(News.class, "News not found");
    }

    @Override
    public Page<News> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public String delete(UUID newsId) {
        Optional<News> news = newsRepository.findById(newsId);

        if (news.isPresent())
            newsRepository.delete(news.get());
        else
            throw new EntityNotFoundException(News.class, "News not found");

        return "Deadline with ID <" + newsId + "> was deleted !";
    }
}
