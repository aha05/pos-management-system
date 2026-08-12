package com.pos.terminal.terminal_assignment;

import com.pos.terminal.terminal.Terminal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TerminalAssignmentRequest {
    @NotNull(message = "Terminal Id is mandatory")
    private Long terminalId;

    @NotNull(message = "Merchant Id is mandatory")
    private Long merchantId;

    @NotNull(message = "Branch Id is mandatory")
    private Long branchId;

    @NotBlank(message = "Assignment Type is mandatory")
    private String assignmentType;

    @NotNull(message = "assignedAt is mandatory")
    private LocalDateTime assignedAt;

    @NotBlank(message = "assignedBy is mandatory")
    private String assignedBy;

    @NotNull(message = "unassignedAt is mandatory")
    private LocalDateTime unassignedAt;

    @NotBlank(message = "unassignedBy is mandatory")
    private String unassignedBy;

    @NotBlank(message = "status is mandatory")
    private String status;

    @NotBlank(message = "reason is mandatory")
    private String reason;
}
