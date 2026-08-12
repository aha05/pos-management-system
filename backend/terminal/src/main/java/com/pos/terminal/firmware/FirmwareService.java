package com.pos.terminal.firmware;

import com.pos.terminal.common.ResourceAlreadyExistException;
import com.pos.terminal.common.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FirmwareService {
    private final FirmwareRepository firmwareRepository;
    private final FirmwareMapper firmwareMapper;

    public TerminalFirmware findFirmwareById(Long firmwareId){
        return firmwareRepository.findById(firmwareId).orElseThrow(
                () -> new ResourceNotFoundException("Firmware", "firmwareId", firmwareId)
        );
    }

    public List<FirmwareResponse> getFirmwares() {
        return firmwareRepository.findAll()
                .stream()
                .map(firmwareMapper::toDto)
                .toList();
    }

    public FirmwareResponse addFirmware(FirmwareRequest request) {
        if (firmwareRepository.existsByFirmwareCode(request.getFirmwareCode())){
            throw new ResourceAlreadyExistException("Firmware", "firmwareCode", request.getFirmwareCode());
        }

        TerminalFirmware terminalFirmware = firmwareMapper.toEntity(request);
        firmwareRepository.save(terminalFirmware);
        return firmwareMapper.toDto(terminalFirmware);
    }
}
