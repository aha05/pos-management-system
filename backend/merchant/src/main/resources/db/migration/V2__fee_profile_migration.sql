create table fee_profile
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    profile_code VARCHAR(20)  NOT NULL UNIQUE,
    profile_name VARCHAR(100) NOT NULL,
    transaction_fee_type   ENUM('PERCENTAGE','FIXED') NOT NULL DEFAULT 'PERCENTAGE',
    transaction_fee        DECIMAL(10,2)      NOT NULL,
    minimum_fee DECIMAL(10,2) DEFAULT 0,
    maximum_fee DECIMAL(10,2) NULL,
    settlement_fee_type ENUM('PERCENTAGE','FIXED') NOT NULL DEFAULT 'FIXED',
    settlement_fee_value DECIMAL(10,2)      NOT NULL DEFAULT 0,
    currency               VARCHAR(3) NOT NULL,
    active                 BOOLEAN NOT NULL DEFAULT TRUE,

    version BIGINT NOT NULL DEFAULT 0,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100)
);
