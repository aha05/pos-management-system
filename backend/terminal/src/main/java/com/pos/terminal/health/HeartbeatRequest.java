package com.pos.terminal.health;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class HeartbeatRequest {
    private Long terminalId;
    private LocalDateTime heartbeatTime;
    private Integer batteryLevel;
    private BigInteger freeStorage;
    private String networkType;
    private Integer signalStrength;
    private String ipAddress;
    private String firmwareVersion;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal deviceTemperature;
}
