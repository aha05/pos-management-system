package com.pos.terminal.common;

public class InvalidStatusTransitionException extends RuntimeException {
    public InvalidStatusTransitionException(String currentStatus, String resourceName, String newStatus) {
        super(String.format("%s %s cannot be %s", currentStatus, resourceName, newStatus));
    }
}
