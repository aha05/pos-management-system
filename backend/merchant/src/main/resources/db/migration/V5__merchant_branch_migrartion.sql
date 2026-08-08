CREATE TABLE merchant_branch
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id  BIGINT       NOT NULL,
    branch_code  VARCHAR(30)  NOT NULL,
    branch_name  VARCHAR(100) NOT NULL,
    phone_number VARCHAR(25)  NULL,
    email        VARCHAR(50)  NULL,
    country      VARCHAR(100) NULL,
    city         VARCHAR(100) NULL,
    sub_city     VARCHAR(100) NULL,
    woreda       VARCHAR(100) NULL,
    address      VARCHAR(255) NULL,
    status       INT          NOT NULL DEFAULT 0,
    version      BIGINT NOT NULL DEFAULT 0,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_merchant_branch_merchant
        FOREIGN KEY (merchant_id)
        REFERENCES merchants (id)
        ON DELETE CASCADE,

    CONSTRAINT uk_merchant_branch_code
        UNIQUE (merchant_id, branch_code)
);

