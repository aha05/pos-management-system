CREATE TABLE terminal_heartbeat
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    terminal_id BIGINT NOT NULL UNIQUE,
    heartbeat_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    battery_level INT,
    free_storage BIGINT NULL,
    network_type VARCHAR(20) NOT NULL,
    signal_strength INT,
    ip_address VARCHAR(45),
    firmware_version VARCHAR(50),
    latitude DECIMAL(10,7) NULL,
    longitude DECIMAL(10,7) NULL,
    device_temperature DECIMAL(5,2) NULL,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_heartbeat_terminal
        FOREIGN KEY (terminal_id)
            REFERENCES terminal(id)
);