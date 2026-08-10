package com.pos.terminal.firmware;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder
@Data
public class FirmwareResponse {
    private Long id;
    private String firmwareCode;
    private String version;
    private String deviceModel;
    private String fileName;
    private String filePath;
    private String fileHash;
    private BigInteger fileSize;
    private LocalDateTime releaseDate;
    private String status;
    private Boolean mandatory;
}
