package com.mscharhag.errorhandling.article;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles/{id}/publish")
    public void publishArticle(@PathVariable ArticleId id) {
        articleService.publishArticle(id);
    }
}
