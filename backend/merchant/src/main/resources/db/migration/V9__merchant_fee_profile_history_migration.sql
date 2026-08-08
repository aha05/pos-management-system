create table merchant_fee_profile_history
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id    BIGINT NOT NULL,
    fee_profile_id BIGINT NOT NULL,
    effective_from   TIMESTAMP  NOT NULL,
    effective_to     TIMESTAMP  NOT NULL,
    assigned_by      VARCHAR(100),
    remarks          TEXT,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_merchant_fee_profile_history_merchant
        FOREIGN KEY (merchant_id)
        REFERENCES merchants (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_merchant_fee_profile_history_fee_profile
        FOREIGN KEY (merchant_id)
        REFERENCES fee_profile (id)
        ON DELETE CASCADE
);
