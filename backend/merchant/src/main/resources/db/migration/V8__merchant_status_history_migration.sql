create table merchant_status_history
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    merchant_id   BIGINT NOT NULL,
    old_status    VARCHAR(50) NOT NULL,
    new_status    VARCHAR(50) NOT NULL,
    changed_by    VARCHAR(50) NOT NULL,
    changed_at    TIMESTAMP,
    reason        TEXT,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_merchant_status_history_merchant
        FOREIGN KEY (merchant_id)
        REFERENCES merchants (id)
        ON DELETE CASCADE
);