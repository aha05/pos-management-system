package com.pos.merchant.merchant;

import lombok.Getter;

@Getter
public enum MerchantStatus {
        PENDING(1),
        ACTIVE(2),
        INACTIVE(3),
        SUSPENDED(4),
        CLOSED(5),
        BLOCKED(6);


        private final int value;

    MerchantStatus(int value) {
            this.value = value;
        }

        public static MerchantStatus fromValue(int value) {
            for (MerchantStatus status : values()) {
                if (status.value == value) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid branch status: " + value);
        }

}
