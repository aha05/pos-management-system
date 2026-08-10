package com.pos.terminal.terminal_assignment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.terminal.terminal.Terminal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "terminal_assignment")
public class TerminalAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @Column(name="merchant_id")
    private Long merchantId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name="assignment_type")
    private String assignmentType;

    @Column(name="assigned_at")
    private LocalDateTime assignedAt;

    @Column(name="assigned_by")
    private String assignedBy;

    @Column(name="unassigned_at")
    private LocalDateTime unassignedAt;

    @Column(name="unassigned_by")
    private String unassignedBy;

    @Column(name="status")
    private String status;

    @Column(name="reason")
    private String reason;
}
