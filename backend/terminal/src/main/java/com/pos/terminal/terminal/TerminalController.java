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
}
