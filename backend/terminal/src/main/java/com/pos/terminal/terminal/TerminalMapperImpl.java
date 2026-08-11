package com.pos.terminal.terminal;

import com.pos.terminal.common.ResourceNotFoundException;
import com.pos.terminal.firmware.FirmwareRepository;
import com.pos.terminal.firmware.TerminalFirmware;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TerminalMapperImpl implements TerminalMapper {
    private final FirmwareRepository firmwareRepository;

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
                .status(terminal.getStatus())
                .inventoryStatus(terminal.getInventoryStatus())
                .registeredAt(terminal.getRegisteredAt())
                .activatedAt(terminal.getActivatedAt())
                .deactivatedAt(terminal.getDeactivatedAt())
                .lastSeenAt(terminal.getLastSeenAt())
                .build();
    }

    @Override
    public Terminal toEntity(TerminalRequest request) {
        Terminal terminal = new Terminal();
        terminal.setTerminalCode(request.getTerminalCode());
        terminal.setSerialNumber(request.getSerialNumber());
        terminal.setDeviceModel(request.getDeviceModel());
        terminal.setManufacturer(request.getManufacturer());
        terminal.setTerminalType(request.getTerminalType());
        terminal.setImei(request.getImei());
        terminal.setSimNumber(request.getSimNumber());
        terminal.setSimIccid(request.getSimIccid());
        terminal.setMacAddress(request.getMacAddress());
        terminal.setCurrentFirmware(findFirmwareById(request.getCurrentFirmwareId()));
        terminal.setStatus(request.getStatus());
        terminal.setInventoryStatus(request.getInventoryStatus());
        terminal.setRegisteredAt(request.getRegisteredAt());
        terminal.setActivatedAt(request.getActivatedAt());
        terminal.setDeactivatedAt(request.getDeactivatedAt());
        terminal.setLastSeenAt(request.getLastSeenAt());
        return terminal;
    }

    private TerminalFirmware findFirmwareById(Long firmwareId){
       return firmwareRepository.findById(firmwareId).orElseThrow(
                () -> new ResourceNotFoundException("Terminal", "firmwareId", firmwareId)
        );
    }
}
