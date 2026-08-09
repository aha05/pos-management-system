package com.pos.merchant.branch;

import lombok.Getter;

@Getter
public enum BranchStatus {

    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3),
    CLOSED(4);

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
