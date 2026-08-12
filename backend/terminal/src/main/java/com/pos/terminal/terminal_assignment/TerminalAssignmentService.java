package com.pos.terminal.terminal_assignment;

import com.pos.terminal.terminal.TerminalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TerminalAssignmentService {
    private final TerminalAssignmentMapper terminalAssignmentMapper;
    private final TerminalAssignmentRepository terminalAssignmentRepository;

    public TerminalAssignmentResponse assignTerminal(TerminalAssignmentRequest request) {

        var terminalAssignment = terminalAssignmentMapper.toEntity(request);
        terminalAssignment = terminalAssignmentRepository.save(terminalAssignment);
        return terminalAssignmentMapper.toDto(terminalAssignment);
    }
}
