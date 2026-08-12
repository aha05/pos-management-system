package com.pos.terminal.health;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("terminal/health")
@RequiredArgsConstructor
public class HealthController {
    private final HealthService healthService;

    @GetMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK)
    public TerminalHealthStatus getHealthStatus(@PathVariable(name = "id") Long terminalId) {
        return healthService.getHealthStatus(terminalId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HeartbeatResponse> getHeartBeat() {
        return healthService.getTerminalHeartBeats();
    }

    @PostMapping("/heartbeat")
    @ResponseStatus(HttpStatus.CREATED)
    public HeartbeatResponse updateHeartBeat(@Valid @RequestBody HeartbeatRequest request) {
        return healthService.updateHeartBeat(request);
    }
}
