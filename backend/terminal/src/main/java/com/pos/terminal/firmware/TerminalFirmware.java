package com.pos.terminal.firmware;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "terminal_firmware")
public class TerminalFirmware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firmware_code")
    private String firmwareCode;

    @Column(name = "version")
    private String version;

    @Column(name = "device_model")
    private String deviceModel;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_hash")
    private String fileHash;

    @Column(name = "file_size")
    private BigInteger fileSize;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "status")
    private String status;

    @Column(name = "mandatory")
    private Boolean mandatory;
}
