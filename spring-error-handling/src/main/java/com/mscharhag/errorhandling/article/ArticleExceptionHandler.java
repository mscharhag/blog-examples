package com.mscharhag.errorhandling.article;

import com.mscharhag.errorhandling.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleExceptionHandler {

    @ExceptionHandler(ArticleNotFoundException.class)

    public ResponseEntity<ErrorResponse> onArticleNotFoundException(ArticleNotFoundException e) {
        String message = String.format("No article with id %s found", e.getArticleId());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("ARTICLE_NOT_FOUND", message));
    }
}
