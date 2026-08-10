package com.pos.terminal.health;

public interface HeartbeatMapper {
    HeartbeatResponse toDto(TerminalHeartbeat terminalHeartbeat);
    TerminalHeartbeat toEntity(HeartbeatRequest request);
}
