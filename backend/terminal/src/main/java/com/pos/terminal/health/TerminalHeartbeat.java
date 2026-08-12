package com.pos.terminal.health;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.terminal.terminal.Terminal;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="terminal_heartbeat")
public class TerminalHeartbeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @Column(name = "heartbeat_time")
    private LocalDateTime heartbeatTime;

    @Column(name = "battery_level")
    private Integer batteryLevel;

    @Column(name = "free_storage")
    private BigInteger freeStorage;

    @Column(name = "network_type")
    private String networkType;

    @Column(name="signal_strength")
    private Integer signalStrength;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "firmware_version")
    private String firmwareVersion;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "device_temperature")
    private BigDecimal deviceTemperature;
}
