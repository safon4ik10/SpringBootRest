package com.example.springbootrest.exception;

/**
 * @author Vladimir Troshin
 * @since 24.01.2023
 */
public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
