package edu.cst438.sprint3.utils;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Username and Password is invalid!")
public
final class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}