package com.pos.terminal.firmware;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FirmwareRepository extends JpaRepository<TerminalFirmware, Long> {
    boolean existsByFirmwareCode(String firmwareCode);
}
