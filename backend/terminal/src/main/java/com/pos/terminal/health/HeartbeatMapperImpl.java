package com.pos.terminal.health;

public class HeartbeatMapperImpl implements HeartbeatMapper {
    @Override
    public HeartbeatResponse toDto(TerminalHeartbeat terminalHeartbeat) {
        return HeartbeatResponse.builder()
                .id(terminalHeartbeat.getId())
                .terminal(terminalHeartbeat.getTerminal())
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
        terminalHeartbeat.setTerminal(request.getTerminal());
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

    public Merchant getMerchantById(Long merchantId){
        return merchantRepository.findById(merchantId).orElse(null);
    }
}
