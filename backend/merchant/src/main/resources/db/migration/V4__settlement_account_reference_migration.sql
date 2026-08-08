create table settlement_account_reference
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id    BIGINT  NOT NULL,
    account_number VARCHAR(40) NOT NULL,
    account_holder_name VARCHAR(100) NOT NULL,
    bank_name VARCHAR(100) NOT NULL,
    bank_code VARCHAR(100) NOT NULL,
    currency   VARCHAR(5)  NOT NULL,
    is_primary BOOLEAN DEFAULT TRUE,
    active     BOOLEAN NOT NULL DEFAULT TRUE,
    account_service_reference_id VARCHAR(50) NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_settlement_account_reference_merchant
        FOREIGN KEY (merchant_id)
        REFERENCES merchants (id)
        ON DELETE CASCADE
);
