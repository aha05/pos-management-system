package com.pos.terminal.terminal_assignment;

import org.springframework.stereotype.Component;

@Component
public class TerminalAssignmentMapperImpl implements TerminalAssignmentMapper {
    @Override
    public TerminalAssignmentResponse toDto(TerminalAssignment terminalAssignment) {
        return TerminalAssignmentResponse.builder()
                .id(terminalAssignment.getId())
                .terminal(terminalAssignment.getTerminal())
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
        terminalAssignment.setTerminal(request.getTerminal());
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
