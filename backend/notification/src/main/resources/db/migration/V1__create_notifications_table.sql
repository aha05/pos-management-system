CREATE TABLE notifications
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    recipient_id   BIGINT       NOT NULL,
    recipient      VARCHAR(150) NOT NULL,
    type           VARCHAR(50)  NOT NULL,
    subject        VARCHAR(150) NOT NULL,
    message        TEXT         NOT NULL,
    status         VARCHAR(20)  NOT NULL DEFAULT 'PENDING',
    created_at     TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    sent_at        TIMESTAMP(6) NULL,
    failure_reason VARCHAR(1000) NULL
);