package com.example.springbootrest.exception;

/**
 * @author Vladimir Troshin
 * @since 24.01.2023
 */
public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}
