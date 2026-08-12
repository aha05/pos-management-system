package com.pos.terminal.terminal;

public interface TerminalMapper {
    TerminalResponse toDto(Terminal terminal);
    Terminal toEntity(TerminalRequest request);
    Terminal update(Terminal terminal, TerminalRequest request);
}
