package com.pos.terminal.firmware;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FirmwareService {
    private final FirmwareRepository firmwareRepository;
    private final FirmwareMapper firmwareMapper;

    public List<FirmwareResponse> getFirmwares() {
        return firmwareRepository.findAll()
                .stream()
                .map(firmwareMapper::toDto)
                .toList();
    }

    public FirmwareResponse addFirmware(FirmwareRequest request) {
        TerminalFirmware terminalFirmware = new TerminalFirmware();
        firmwareRepository.save(terminalFirmware);
        return firmwareMapper.toDto(terminalFirmware);
    }
}
