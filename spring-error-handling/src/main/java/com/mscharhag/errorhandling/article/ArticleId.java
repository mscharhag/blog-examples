package com.mscharhag.errorhandling.article;

import java.util.Objects;
import java.util.UUID;

public class ArticleId {
    private String value;

    public ArticleId(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public ArticleId() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleId articleId = (ArticleId) o;
        return Objects.equals(value, articleId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
