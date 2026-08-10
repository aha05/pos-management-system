package com.pos.terminal.health;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartbeatRepository extends JpaRepository<TerminalHeartbeat, Long> {
}
