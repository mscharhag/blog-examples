package com.mscharhag.errorhandling.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void publishArticle(ArticleId id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id));

        if (!article.isApproved()) {
            throw new ArticleNotApprovedException(article);
        }

        // publish article
        System.out.println("publishing article :)");
    }
}
