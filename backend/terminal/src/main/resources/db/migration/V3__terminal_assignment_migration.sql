CREATE TABLE terminal_assignment
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    terminal_id BIGINT NOT NULL,
    merchant_id BIGINT NOT NULL,
    branch_id BIGINT NOT NULL,

    assignment_type VARCHAR(30) NOT NULL,

    assigned_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    assigned_by VARCHAR(100),

    unassigned_at TIMESTAMP NULL,
    unassigned_by VARCHAR(100) NULL,

    status ENUM('ACTIVE', 'ENDED') NOT NULL DEFAULT 'ACTIVE',

    reason VARCHAR(255) NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(100),

    CONSTRAINT fk_assignment_terminal
        FOREIGN KEY (terminal_id)
            REFERENCES terminal(id)
);