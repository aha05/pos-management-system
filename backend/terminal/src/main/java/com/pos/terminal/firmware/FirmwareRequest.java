package com.pos.terminal.firmware;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class FirmwareRequest {
    @NotBlank(message = "Firmware Code is mandatory")
    private String firmwareCode;

    @NotBlank(message = "Version is mandatory")
    private String version;

    @NotBlank(message = "Device Model is mandatory")
    private String deviceModel;

    @NotBlank(message = "File Name is mandatory")
    private String fileName;

    @NotBlank(message = "File Path is mandatory")
    private String filePath;

    @NotBlank(message = "File Hash is mandatory")
    private String fileHash;

    @NotNull(message = "File Size is mandatory")
    private BigInteger fileSize;

    @NotNull(message = "Release Date is mandatory")
    private LocalDateTime releaseDate;

    @NotBlank(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Status is mandatory")
    private Boolean mandatory;
}
