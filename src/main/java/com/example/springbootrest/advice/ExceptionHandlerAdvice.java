package com.example.springbootrest.advice;

import com.example.springbootrest.exception.InvalidCredentials;
import com.example.springbootrest.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Vladimir Troshin
 * @since 24.01.2023
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String ecHandler(InvalidCredentials e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String uuHandler(UnauthorizedUser e){
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
