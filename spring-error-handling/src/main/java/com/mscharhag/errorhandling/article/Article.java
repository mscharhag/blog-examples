package com.mscharhag.errorhandling.article;

public class Article {

    private final ArticleId id = new ArticleId();
    private String text;
    private boolean approved = false;

    public boolean isApproved() {
        return approved;
    }

    public ArticleId getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
