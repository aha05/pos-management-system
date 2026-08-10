package com.pos.terminal.terminal_assignment;

import com.pos.terminal.terminal.Terminal;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TerminalAssignmentRequest {
    private Terminal terminal;
    private Long merchantId;
    private Long branchId;
    private String assignmentType;
    private LocalDateTime assignedAt;
    private String assignedBy;
    private LocalDateTime unassignedAt;
    private String unassignedBy;
    private String status;
    private String reason;
}
