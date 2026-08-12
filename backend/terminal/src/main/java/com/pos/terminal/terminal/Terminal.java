package com.pos.terminal.terminal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.terminal.audit.BaseEntity;
import com.pos.terminal.firmware.TerminalFirmware;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "terminal")
public class Terminal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "terminal_code", unique = true)
    private String terminalCode;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @Column(name = "device_model")
    private String deviceModel;

    @Column(name = "manufacturer")
    private String  manufacturer;

    @Column(name = "terminal_type")
    private String terminalType;

    @Column(name = "imei")
    private String imei;

    @Column(name = "sim_number")
    private String simNumber;

    @Column(name = "sim_iccid")
    private String simIccid;

    @Column(name = "mac_address")
    private String macAddress;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "current_firmware_id")
    private TerminalFirmware currentFirmware;

    @Column(name = "status")
    private String status;

    @Column(name = "inventory_status")
    private String inventoryStatus;


    @Column(name = "registered_at")
    private String registeredAt;

    @Column(name = "activated_at")
    private LocalDateTime activatedAt;

    @Column(name = "deactivated_at")
    private LocalDateTime deactivatedAt;

    @Column(name = "last_seen_at")
    private LocalDateTime  lastSeenAt;
}
