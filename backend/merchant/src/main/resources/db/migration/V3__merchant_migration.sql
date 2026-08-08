CREATE TABLE merchants
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_code VARCHAR(25) NOT NULL UNIQUE,
    legal_name VARCHAR(255) NOT NULL,
    trade_name VARCHAR(255),
    tin_number varchar(50),
    business_license varchar(255),

    category_id BIGINT NOT NULL,
    fee_profile_id BIGINT NOT NULL,

    status INT NOT NULL DEFAULT 1,

    phone_number varchar(25),
    email VARCHAR(100),
    website VARCHAR(100),

    country varchar(50),
    city VARCHAR(50),
    sub_city VARCHAR(50),
    woreda VARCHAR(50),
    address VARCHAR(255),
    house_no VARCHAR(50),

    version BIGINT NOT NULL DEFAULT 0,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),

    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_merchant_category_merchant
        FOREIGN KEY (category_id)
        REFERENCES merchant_category (id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_fee_profile_merchant
        FOREIGN KEY (fee_profile_id)
            REFERENCES fee_profile (id)
            ON DELETE RESTRICT
);