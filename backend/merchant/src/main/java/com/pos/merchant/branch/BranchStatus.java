package com.pos.merchant.branch;

import lombok.Getter;

@Getter
public enum BranchStatus {
    PENDING(1),
    ACTIVE(2),
    INACTIVE(3),
    SUSPENDED(4),
    CLOSED(5),
    BLOCKED(6);

    private final int value;

    BranchStatus(int value) {
        this.value = value;
    }

    public static BranchStatus fromValue(int value) {
        for (BranchStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid branch status: " + value);
    }
}
