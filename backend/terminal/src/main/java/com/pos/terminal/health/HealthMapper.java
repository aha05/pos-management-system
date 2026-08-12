package com.pos.terminal.health;

import com.pos.terminal.terminal.Terminal;

public interface HealthMapper {
    HeartbeatResponse toDto(TerminalHeartbeat terminalHeartbeat);
    TerminalHealthStatus toDto(Terminal terminal, TerminalConnectivityStatus status);
    TerminalHeartbeat toEntity(HeartbeatRequest request);
    TerminalHeartbeat update(TerminalHeartbeat terminalHeartbeaterminalHeartbeat, HeartbeatRequest request);
}
