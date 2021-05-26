package com.mscharhag.errorhandling.article;

public class ArticleNotFoundException extends RuntimeException {
    private final ArticleId articleId;

    public ArticleNotFoundException(ArticleId articleId) {
        super(String.format("No article with id %s found", articleId));
        this.articleId = articleId;
    }

    public ArticleId getArticleId() {
        return articleId;
    }

}
