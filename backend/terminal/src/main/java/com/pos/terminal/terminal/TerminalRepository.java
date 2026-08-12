package com.pos.terminal.terminal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TerminalRepository extends JpaRepository<Terminal, Long> {
    boolean existsByTerminalCode(String terminalCode);
    boolean existsBySerialNumber(String serialNumber);
    boolean existsByImei(String imei);
}
