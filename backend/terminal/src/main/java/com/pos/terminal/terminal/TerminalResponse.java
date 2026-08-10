package com.pos.terminal.terminal;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder
@Data
public class TerminalResponse {
    private Long id;
    private String terminalCode;
    private String serialNumber;
    private String deviceModel;
    private String  manufacturer;
    private String terminalType;
    private String imei;
    private String simNumber;
    private String simIccid;
    private String macAddress;
    private BigInteger currentFirmwareId;
    private String status;
    private String inventoryStatus;
    private String registeredAt;
    private LocalDateTime activatedAt;
    private LocalDateTime deactivatedAt;
    private LocalDateTime  lastSeenAt;
}
