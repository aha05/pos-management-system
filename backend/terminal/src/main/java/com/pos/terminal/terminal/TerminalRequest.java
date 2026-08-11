package com.pos.terminal.terminal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class TerminalRequest {
    @NotBlank(message = "Terminal Code is mandatory")
    private String terminalCode;

    @NotBlank(message = "Serial Number is mandatory")
    private String serialNumber;

    @NotBlank(message = "Device Model is mandatory")
    private String deviceModel;

    @NotBlank(message = "Manufacturer is mandatory")
    private String  manufacturer;

    @NotBlank(message = "Terminal Type is mandatory")
    private String terminalType;

    @NotBlank(message = "imei Type is mandatory")
    private String imei;

    @NotBlank(message = "Sim Number Type is mandatory")
    private String simNumber;

    @NotBlank(message = "Sim Iccid Type is mandatory")
    private String simIccid;

    @NotBlank(message = "Mac Address Type is mandatory")
    private String macAddress;

    @NotNull(message = "Current Firmware Id Type is mandatory")
    private Long currentFirmwareId;

    @NotBlank(message = "Status Type is mandatory")
    private String status;

    @NotBlank(message = "Inventory Status is mandatory")
    private String inventoryStatus;

    @NotBlank(message = "registeredAt is mandatory")
    private String registeredAt;

    @NotNull(message = "activatedAt is mandatory")
    private LocalDateTime activatedAt;

    @NotNull(message = "deactivatedAt is mandatory")
    private LocalDateTime deactivatedAt;

    @NotNull(message = "lastSeenAt is mandatory")
    private LocalDateTime  lastSeenAt;
}
