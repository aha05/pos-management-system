package com.pos.merchant.branch;

public enum BranchStatus {
    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3),
    CLOSED(4);

    private final int value;

    BranchStatus(int value) {
        this.value = value;
    }
}
