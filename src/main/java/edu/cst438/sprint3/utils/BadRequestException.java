package edu.cst438.sprint3.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Product ID is invalid!")
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;}