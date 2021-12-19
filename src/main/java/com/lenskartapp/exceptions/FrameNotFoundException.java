package com.lenskartapp.exceptions;

public class FrameNotFoundException extends RuntimeException{
    public FrameNotFoundException() {
    }

    public FrameNotFoundException(String message) {
        super(message);
    }
}
