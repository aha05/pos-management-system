package com.pos.terminal.terminal;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("terminal")
@RequiredArgsConstructor
public class TerminalController {
    private final TerminalService terminalService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TerminalResponse> getTerminals() {
        return terminalService.getTerminals();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TerminalResponse addTerminal(@Valid @RequestBody TerminalRequest request) {
        return terminalService.addTerminal(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TerminalResponse updateTerminal(@Valid @RequestBody TerminalRequest request, Long terminalId) {
        return terminalService.updateTerminal(request, terminalId);
    }

    @PostMapping("/{id}/change-status")
    @ResponseStatus(HttpStatus.CREATED)
    public ChangeStatusResponse updateTerminalStatus(
            @PathVariable(name = "id") Long terminalId,
            @Valid @RequestBody ChangeStatusRequest request) {
        return terminalService.updateTerminalStatus(terminalId, request);
    }
}
