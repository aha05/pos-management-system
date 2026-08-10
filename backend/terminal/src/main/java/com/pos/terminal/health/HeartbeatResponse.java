package com.pos.terminal.health;

import com.pos.terminal.terminal.Terminal;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Builder
@Data
public class HeartbeatResponse {
    private Long id;
    private Terminal terminal;
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
