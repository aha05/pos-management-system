package com.pos.terminal.terminal;

import com.pos.terminal.common.InvalidStatusTransitionException;
import com.pos.terminal.common.ResourceAlreadyExistException;
import com.pos.terminal.common.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TerminalService {
    private final TerminalRepository terminalRepository;
    private final TerminalMapper terminalMapper;

    public Terminal findTerminalById(Long terminalId){
        return terminalRepository.findById(terminalId).orElseThrow(
                () -> new ResourceNotFoundException("Terminal", "terminalId", terminalId)
        );
    }

    public List<TerminalResponse> getTerminals() {
        return terminalRepository.findAll()
                .stream()
                .map(terminalMapper::toDto)
                .toList();
    }

    public TerminalResponse addTerminal(TerminalRequest request) {

        validateUniqueFields(request);

        var terminal = terminalMapper.toEntity(request);
        terminal = terminalRepository.save(terminal);
        return terminalMapper.toDto(terminal);
    }

    private void validateUniqueFields(TerminalRequest request) {
        if (terminalRepository.existsByTerminalCode(request.getTerminalCode())){
            throw new ResourceAlreadyExistException("Terminal", "terminalCode", request.getTerminalCode());
        }

        if (terminalRepository.existsBySerialNumber(request.getSerialNumber())){
            throw new ResourceAlreadyExistException("Terminal", "serialNumber", request.getSerialNumber());
        }

        if (terminalRepository.existsByImei(request.getImei())){
            throw new ResourceAlreadyExistException("Terminal", "IMIE", request.getImei());
        }
    }

    @Transactional
    public ChangeStatusResponse updateTerminalStatus(Long terminalId, ChangeStatusRequest request) {
        var terminal =  findTerminalById(terminalId);
        if (terminal.getStatus() == TerminalStatus.DECOMMISSIONED) {
            throw new InvalidStatusTransitionException(TerminalStatus.DECOMMISSIONED.toString(), "terminal", request.getStatus().toString());
        }

        terminal.setStatus(request.getStatus());

        return ChangeStatusResponse.builder()
                .terminalId(terminal.getId())
                .status(terminal.getStatus())
                .build();
    }
}
