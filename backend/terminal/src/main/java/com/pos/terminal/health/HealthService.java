package com.pos.terminal.health;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HealthService {
    public List<HeartbeatResponse> getTerminalHeartBeats() {
        return null;
    }

    public HeartbeatResponse updateHeartBeat(HeartbeatRequest request) {
        return null;
    }
}
