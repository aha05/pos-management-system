create table merchant_category
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_code VARCHAR(20)  NOT NULL UNIQUE,
    category_name VARCHAR(100) NOT NULL,
    description   TEXT         null,
    active        BOOLEAN      NOT NULL DEFAULT true,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100)
);
