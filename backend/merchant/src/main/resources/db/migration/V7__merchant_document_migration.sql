create table merchant_document
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id   BIGINT  NOT NULL,
    document_type VARCHAR(50) NOT NULL,
    file_name     VARCHAR(255),
    storage_path  VARCHAR(500) NOT NULL,
    verified      BOOLEAN NOT NULL DEFAULT FALSE,

    version BIGINT NOT NULL DEFAULT 0,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_merchant_document_merchant
        FOREIGN KEY (merchant_id)
        REFERENCES merchants (id)
        ON DELETE CASCADE
);
