package com.mscharhag.errorhandling.article;

public class ArticleNotApprovedException extends RuntimeException {
    private final Article article;

    public ArticleNotApprovedException(Article article) {
        super(String.format("Article %s is not approved", article.getId()));
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
