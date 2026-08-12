package com.pos.terminal.terminal_assignment;

import com.pos.terminal.terminal.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TerminalAssignmentMapperImpl implements TerminalAssignmentMapper {
    private final TerminalService terminalService;

    @Override
    public TerminalAssignmentResponse toDto(TerminalAssignment terminalAssignment) {
        return TerminalAssignmentResponse.builder()
                .id(terminalAssignment.getId())
                .terminalId(terminalAssignment.getTerminal().getId())
                .merchantId(terminalAssignment.getMerchantId())
                .branchId(terminalAssignment.getBranchId())
                .assignmentType(terminalAssignment.getAssignmentType())
                .assignedAt(terminalAssignment.getAssignedAt())
                .assignedBy(terminalAssignment.getAssignedBy())
                .unassignedAt(terminalAssignment.getUnassignedAt())
                .status(terminalAssignment.getStatus())
                .reason(terminalAssignment.getReason())
                .build();
    }

    @Override
    public TerminalAssignment toEntity(TerminalAssignmentRequest request) {
        TerminalAssignment terminalAssignment = new TerminalAssignment();
        terminalAssignment.setTerminal(terminalService.findTerminalById(request.getTerminalId()));
        terminalAssignment.setMerchantId(request.getMerchantId());
        terminalAssignment.setBranchId(request.getBranchId());
        terminalAssignment.setAssignmentType(request.getAssignmentType());
        terminalAssignment.setAssignedAt(request.getAssignedAt());
        terminalAssignment.setAssignedBy(request.getAssignedBy());
        terminalAssignment.setUnassignedAt(request.getUnassignedAt());
        terminalAssignment.setUnassignedBy(request.getUnassignedBy());
        terminalAssignment.setStatus(request.getStatus());
        terminalAssignment.setReason(request.getReason());
        return terminalAssignment;
    }
}
