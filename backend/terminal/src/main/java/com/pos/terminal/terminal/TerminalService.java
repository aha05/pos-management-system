package com.pos.terminal.terminal;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final TerminalMapper terminalMapper;

    public List<TerminalResponse> getTerminals() {
        return terminalRepository.findAll()
                .stream()
                .map(terminalMapper::toDto)
                .toList();
    }

    public TerminalResponse addTerminal(TerminalRequest request) {
        var terminal = terminalMapper.toEntity(request);
        terminalRepository.save(terminal);
        return terminalMapper.toDto(terminal);
    }
}
