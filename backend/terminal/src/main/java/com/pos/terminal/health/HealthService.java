package com.pos.terminal.health;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HealthService {
    private final HeartbeatRepository heartbeatRepository;
    private final HeartbeatMapper heartbeatMapper;

    public List<HeartbeatResponse> getTerminalHeartBeats() {
        return heartbeatRepository.findAll()
                .stream()
                .map(heartbeatMapper::toDto)
                .toList();
    }

    public HeartbeatResponse updateHeartBeat(HeartbeatRequest request) {
        var terminalHeartbeat = heartbeatRepository.findByTerminalId(request.getTerminalId()).orElse(null);
        if (terminalHeartbeat == null){
            var newTerminalHeartbeat = heartbeatMapper.toEntity(request);
            newTerminalHeartbeat = heartbeatRepository.save(newTerminalHeartbeat);
            return heartbeatMapper.toDto(newTerminalHeartbeat);
        }

        var update = heartbeatMapper.update(terminalHeartbeat, request);
        terminalHeartbeat = heartbeatRepository.save(update);
        return heartbeatMapper.toDto(terminalHeartbeat);
    }
}
