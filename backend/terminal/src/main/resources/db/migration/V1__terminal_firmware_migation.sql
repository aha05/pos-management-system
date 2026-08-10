CREATE TABLE terminal_firmware
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firmware_code VARCHAR(25) NOT NULL UNIQUE,
    version VARCHAR(50) NOT NULL,
    device_model VARCHAR(100) NOT NULL,
    file_name varchar(255),
    file_path varchar(500),
    file_hash varchar(128),
    file_size BIGINT,
    release_date TIMESTAMP,
    status VARCHAR(30),
    mandatory BOOLEAN,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by   VARCHAR(100),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by   VARCHAR(100)
);