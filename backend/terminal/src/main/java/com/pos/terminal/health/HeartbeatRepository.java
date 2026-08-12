package com.pos.terminal.health;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartbeatRepository extends JpaRepository<TerminalHeartbeat, Long> {
    Optional<TerminalHeartbeat> findByTerminalId(Long terminalId);
}
