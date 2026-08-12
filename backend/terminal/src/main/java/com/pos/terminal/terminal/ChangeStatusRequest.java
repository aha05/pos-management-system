package com.pos.terminal.terminal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangeStatusRequest {
    @NotNull(message = "Status is mandatory")
    private TerminalStatus status;
}
