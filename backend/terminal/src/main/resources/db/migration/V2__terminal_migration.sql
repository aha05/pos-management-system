CREATE TABLE terminal
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    terminal_code VARCHAR(50) NOT NULL UNIQUE,
    serial_number VARCHAR(100) NOT NULL UNIQUE,
    device_model VARCHAR(100) NOT NULL,
    manufacturer varchar(100) NOT NULL,
    terminal_type varchar(30) NOT NULL,
    imei VARCHAR(30) UNIQUE,
    sim_number VARCHAR(30) NOT NULL,
    sim_iccid VARCHAR(30) NOT NULL,
    mac_address VARCHAR(50) NOT NULL,
    current_firmware_id BIGINT NOT NULL,
    status VARCHAR(30) NOT NULL,
    inventory_status VARCHAR(30),
    registered_at TIMESTAMP NULL,
    activated_at TIMESTAMP NULL,
    deactivated_at TIMESTAMP NULL,
    last_seen_at TIMESTAMP NULL,

    version BIGINT NOT NULL,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100),

    CONSTRAINT fk_firmware_terminal
        FOREIGN KEY (current_firmware_id)
            REFERENCES terminal_firmware (id)
            ON DELETE RESTRICT
);