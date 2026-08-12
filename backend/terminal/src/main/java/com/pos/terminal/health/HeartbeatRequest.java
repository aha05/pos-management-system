package com.pos.terminal.health;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class HeartbeatRequest {
    @NotNull(message = "Terminal Id is mandatory")
    private Long terminalId;

    @NotNull(message = "Heartbeat Time is mandatory")
    private LocalDateTime heartbeatTime;

    @NotNull(message = "Battery Level is mandatory")
    private Integer batteryLevel;

    @NotNull(message = "Free Storage is mandatory")
    private BigInteger freeStorage;

    @NotBlank(message = "Network Type is mandatory")
    private String networkType;

    @NotNull(message = "Signal Strength is mandatory")
    private Integer signalStrength;

    @NotBlank(message = "Ip Address is mandatory")
    private String ipAddress;

    @NotBlank(message = "Firmware Version is mandatory")
    private String firmwareVersion;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal deviceTemperature;
}
