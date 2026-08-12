package com.pos.terminal.terminal_assignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalAssignmentRepository extends JpaRepository<TerminalAssignment, Long> {
    boolean existsByTerminalId(Long terminalId);
}
