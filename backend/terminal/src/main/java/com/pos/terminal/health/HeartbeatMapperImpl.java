package com.pos.terminal.health;

import com.pos.terminal.terminal.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeartbeatMapperImpl implements HeartbeatMapper {
    private final TerminalService terminalService;

    @Override
    public HeartbeatResponse toDto(TerminalHeartbeat terminalHeartbeat) {
        return HeartbeatResponse.builder()
                .id(terminalHeartbeat.getId())
                .terminalId(terminalHeartbeat.getTerminal().getId())
                .heartbeatTime(terminalHeartbeat.getHeartbeatTime())
                .batteryLevel(terminalHeartbeat.getBatteryLevel())
                .freeStorage(terminalHeartbeat.getFreeStorage())
                .networkType(terminalHeartbeat.getNetworkType())
                .signalStrength(terminalHeartbeat.getSignalStrength())
                .ipAddress(terminalHeartbeat.getIpAddress())
                .firmwareVersion(terminalHeartbeat.getFirmwareVersion())
                .latitude(terminalHeartbeat.getLatitude())
                .longitude(terminalHeartbeat.getLongitude())
                .deviceTemperature(terminalHeartbeat.getDeviceTemperature())
                .build();
    }

    @Override
    public TerminalHeartbeat toEntity(HeartbeatRequest request) {
        TerminalHeartbeat terminalHeartbeat = new TerminalHeartbeat();
        terminalHeartbeat.setTerminal(
                terminalService.getTerminalById(
                        request.getTerminalId()));
        terminalHeartbeat.setHeartbeatTime(request.getHeartbeatTime());
        terminalHeartbeat.setBatteryLevel(request.getBatteryLevel());
        terminalHeartbeat.setFreeStorage(request.getFreeStorage());
        terminalHeartbeat.setNetworkType(request.getNetworkType());
        terminalHeartbeat.setSignalStrength(request.getSignalStrength());
        terminalHeartbeat.setIpAddress(request.getIpAddress());
        terminalHeartbeat.setFirmwareVersion(request.getFirmwareVersion());
        terminalHeartbeat.setLatitude(request.getLatitude());
        terminalHeartbeat.setLongitude(request.getLongitude());
        terminalHeartbeat.setDeviceTemperature(request.getDeviceTemperature());

        return terminalHeartbeat;
    }

    @Override
    public TerminalHeartbeat update(TerminalHeartbeat terminalHeartbeat, HeartbeatRequest request) {
        return TerminalHeartbeat.builder()
                .id(terminalHeartbeat.getId())
                .terminal(terminalHeartbeat.getTerminal())
                .heartbeatTime(request.getHeartbeatTime())
                .batteryLevel(request.getBatteryLevel())
                .freeStorage(request.getFreeStorage())
                .networkType(request.getNetworkType())
                .signalStrength(request.getSignalStrength())
                .ipAddress(request.getIpAddress())
                .firmwareVersion(request.getFirmwareVersion())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .deviceTemperature(request.getDeviceTemperature())
                .build();
    }
}
