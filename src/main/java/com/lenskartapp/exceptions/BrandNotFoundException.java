package com.lenskartapp.exceptions;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException() {
    }

    public BrandNotFoundException(String message) {
        super(message);
    }
}
