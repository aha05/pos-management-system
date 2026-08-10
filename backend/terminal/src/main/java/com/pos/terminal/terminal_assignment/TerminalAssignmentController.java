package com.pos.terminal.terminal_assignment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("terminal/assignment")
@RequiredArgsConstructor
public class TerminalAssignmentController {
    private final TerminalAssignmentService terminalAssignmentService;

    @PostMapping("/assign")
    @ResponseStatus(HttpStatus.CREATED)
    public TerminalAssignmentResponse assignTerminal(@Valid @RequestBody TerminalAssignmentRequest request) {
        return terminalAssignmentService.assignTerminal(request);
    }
}
