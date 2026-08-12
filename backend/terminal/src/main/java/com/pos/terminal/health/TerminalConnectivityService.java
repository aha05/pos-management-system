package com.pos.terminal.health;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TerminalConnectivityService {

    private static final long OFFLINE_THRESHOLD_MINUTES = 1;

    public TerminalConnectivityStatus getStatus(
            LocalDateTime heartbeatTime
    ) {

        if (heartbeatTime == null) {
            return TerminalConnectivityStatus.OFFLINE;
        }

        var threshold = LocalDateTime.now()
                .minusMinutes(OFFLINE_THRESHOLD_MINUTES);

        return heartbeatTime.isAfter(threshold)
                ? TerminalConnectivityStatus.ONLINE
                : TerminalConnectivityStatus.OFFLINE;
    }
}
