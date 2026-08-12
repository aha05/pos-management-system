package com.pos.terminal.terminal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangeStatusResponse {
    private Long terminalId;
    private TerminalStatus status;
}
