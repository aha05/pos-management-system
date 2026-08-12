package com.pos.terminal.terminal;

import com.pos.terminal.firmware.FirmwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TerminalMapperImpl implements TerminalMapper {
    private final FirmwareService firmwareService;

    @Override
    public TerminalResponse toDto(Terminal terminal) {
        return TerminalResponse.builder()
                .id(terminal.getId())
                .terminalCode(terminal.getTerminalCode())
                .serialNumber(terminal.getSerialNumber())
                .deviceModel(terminal.getDeviceModel())
                .manufacturer(terminal.getManufacturer())
                .terminalType(terminal.getTerminalType())
                .imei(terminal.getImei())
                .simNumber(terminal.getSimNumber())
                .simIccid(terminal.getSimIccid())
                .macAddress(terminal.getMacAddress())
                .currentFirmwareId(terminal.getCurrentFirmware().getId())
                .status(terminal.getStatus().toString())
                .inventoryStatus(terminal.getInventoryStatus())
                .registeredAt(terminal.getRegisteredAt())
                .activatedAt(terminal.getActivatedAt())
                .deactivatedAt(terminal.getDeactivatedAt())
                .lastSeenAt(terminal.getLastSeenAt())
                .build();
    }

    @Override
    public Terminal toEntity(TerminalRequest request) {
        return Terminal.builder()
                .terminalCode(request.getTerminalCode())
                .serialNumber(request.getSerialNumber())
                .deviceModel(request.getDeviceModel())
                .manufacturer(request.getManufacturer())
                .terminalType(request.getTerminalType())
                .imei(request.getImei())
                .simNumber(request.getSimNumber())
                .simIccid(request.getSimIccid())
                .macAddress(request.getMacAddress())
                .currentFirmware(firmwareService
                        .findFirmwareById(
                                request.getCurrentFirmwareId()))
                .status(request.getStatus())
                .inventoryStatus(request.getInventoryStatus())
                .registeredAt(request.getRegisteredAt())
                .activatedAt(request.getActivatedAt())
                .deactivatedAt(request.getDeactivatedAt())
                .lastSeenAt(request.getLastSeenAt())
                .build();
    }

    @Override
    public Terminal update(Terminal terminal, TerminalRequest request) {
        return Terminal.builder()
                .id(terminal.getId())
                .terminalCode(request.getTerminalCode())
                .serialNumber(request.getSerialNumber())
                .deviceModel(request.getDeviceModel())
                .manufacturer(request.getManufacturer())
                .terminalType(request.getTerminalType())
                .imei(request.getImei())
                .simNumber(request.getSimNumber())
                .simIccid(request.getSimIccid())
                .macAddress(request.getMacAddress())
                .currentFirmware(firmwareService
                        .findFirmwareById(
                                request.getCurrentFirmwareId()))
                .status(request.getStatus())
                .inventoryStatus(request.getInventoryStatus())
                .registeredAt(request.getRegisteredAt())
                .activatedAt(request.getActivatedAt())
                .deactivatedAt(request.getDeactivatedAt())
                .lastSeenAt(request.getLastSeenAt())
                .build();
    }
}
