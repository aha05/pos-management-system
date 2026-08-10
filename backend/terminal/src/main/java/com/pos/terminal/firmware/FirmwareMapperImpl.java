package com.pos.terminal.firmware;

import org.springframework.stereotype.Component;

@Component
public class FirmwareMapperImpl implements FirmwareMapper {
    @Override
    public FirmwareResponse toDto(TerminalFirmware terminalFirmware) {
        return FirmwareResponse.builder()
                .id(terminalFirmware.getId())
                .firmwareCode(terminalFirmware.getFirmwareCode())
                .version(terminalFirmware.getVersion())
                .deviceModel(terminalFirmware.getDeviceModel())
                .fileName(terminalFirmware.getFileName())
                .filePath(terminalFirmware.getFilePath())
                .fileHash(terminalFirmware.getFileHash())
                .fileSize(terminalFirmware.getFileSize())
                .releaseDate(terminalFirmware.getReleaseDate())
                .status(terminalFirmware.getStatus())
                .mandatory(terminalFirmware.getMandatory())
                .build();
    }

    @Override
    public TerminalFirmware toEntity(FirmwareRequest request) {
        TerminalFirmware terminalFirmware = new TerminalFirmware();
        terminalFirmware.setFirmwareCode(request.getFirmwareCode());
        terminalFirmware.setVersion(request.getVersion());
        terminalFirmware.setDeviceModel(request.getDeviceModel());
        terminalFirmware.setFileName(request.getFileName());
        terminalFirmware.setFilePath(request.getFilePath());
        terminalFirmware.setFileHash(request.getFileHash());
        terminalFirmware.setFileSize(request.getFileSize());
        terminalFirmware.setReleaseDate(request.getReleaseDate());
        terminalFirmware.setStatus(request.getStatus());
        terminalFirmware.setMandatory(request.getMandatory());
        return terminalFirmware;
    }
}
