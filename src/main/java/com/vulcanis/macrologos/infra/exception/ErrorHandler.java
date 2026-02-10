package com.vulcanis.macrologos.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handle400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors().stream()
                .map(ValidationErrorData::new)
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handle400Readable(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessageData(ex.getMessage()));
    }

    private record ValidationErrorData(String field, String message) {
        public ValidationErrorData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    private record ErrorMessageData(String message) {}
}