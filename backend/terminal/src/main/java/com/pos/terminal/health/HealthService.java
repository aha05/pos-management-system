package com.pos.terminal.health;

import com.pos.terminal.common.InvalidOperationException;
import com.pos.terminal.terminal.TerminalService;
import com.pos.terminal.terminal.TerminalStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HealthService {
    private final HeartbeatRepository heartbeatRepository;
    private final HealthMapper heartbeatMapper;
    private final TerminalService terminalService;
    private final TerminalConnectivityService connectivityService;
    private final HealthMapper healthMapper;

    public TerminalHealthStatus getHealthStatus(Long id) {

        var terminal =  terminalService.findTerminalById(id);

        var heartbeat = heartbeatRepository.findByTerminalId(id).orElse(null);

        var connectivityStatus =
                connectivityService.getStatus(
                        heartbeat != null
                                ? heartbeat.getHeartbeatTime()
                                : null
                );

        return healthMapper.toDto(terminal, connectivityStatus);
    }


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

       var terminal = terminalService.findTerminalById(request.getTerminalId());
        if (terminal.getStatus() != TerminalStatus.ACTIVE) {
            throw new InvalidOperationException(
                    "Terminal is not active"
            );
        }

        var update = heartbeatMapper.update(terminalHeartbeat, request);
        terminalHeartbeat = heartbeatRepository.save(update);
        return heartbeatMapper.toDto(terminalHeartbeat);
    }
}
