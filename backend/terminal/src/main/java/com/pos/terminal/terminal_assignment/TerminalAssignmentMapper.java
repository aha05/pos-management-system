package com.pos.terminal.terminal_assignment;

public interface TerminalAssignmentMapper {
    TerminalAssignmentResponse toDto(TerminalAssignment terminalAssignment);
    TerminalAssignment toEntity(TerminalAssignmentRequest terminalAssignmentRequest);
}
