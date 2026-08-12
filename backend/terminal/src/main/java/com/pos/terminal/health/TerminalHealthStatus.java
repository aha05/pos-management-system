package com.pos.terminal.health;

import com.pos.terminal.terminal.TerminalStatus;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TerminalHealthStatus {
    Long id;
    String terminalCode;
    String serialNumber;
    String imei;
    TerminalStatus status;
    TerminalConnectivityStatus connectivityStatus;
}
