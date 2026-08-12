package com.pos.terminal.terminal_assignment;

import com.pos.terminal.common.ResourceAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TerminalAssignmentService {
    private final TerminalAssignmentMapper terminalAssignmentMapper;
    private final TerminalAssignmentRepository terminalAssignmentRepository;

    public TerminalAssignmentResponse assignTerminal(TerminalAssignmentRequest request) {
        if (terminalAssignmentRepository.existsByTerminalId(request.getTerminalId())){
            throw new ResourceAlreadyExistException("Merchant or Branch", "terminalId", request.getTerminalId());
        }
        var terminalAssignment = terminalAssignmentMapper.toEntity(request);
        terminalAssignment = terminalAssignmentRepository.save(terminalAssignment);
        return terminalAssignmentMapper.toDto(terminalAssignment);
    }
}
