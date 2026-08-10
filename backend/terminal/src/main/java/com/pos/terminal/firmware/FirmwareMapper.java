package com.pos.terminal.firmware;

public interface FirmwareMapper {
    FirmwareResponse toDto(TerminalFirmware terminalFirmware);
    TerminalFirmware toEntity(FirmwareRequest request);
}
