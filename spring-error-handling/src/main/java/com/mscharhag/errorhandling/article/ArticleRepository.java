package com.mscharhag.errorhandling.article;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ArticleRepository {
    public Optional<Article> findById(ArticleId id) {
        return Optional.empty();
    }
}
