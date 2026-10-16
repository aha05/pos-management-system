package com.pos.terminal.terminal_assignment;

import com.pos.terminal.common.ResourceAlreadyExistException;
import com.pos.terminal.terminal_assignment.client.MerchantFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TerminalAssignmentService {
    private final TerminalAssignmentMapper terminalAssignmentMapper;
    private final TerminalAssignmentRepository terminalAssignmentRepository;
    private final MerchantFeignClient merchantFeignClient;

    public TerminalAssignmentResponse assignTerminal(TerminalAssignmentRequest request) {
        if (terminalAssignmentRepository.existsByTerminalId(request.getTerminalId())){
            throw new ResourceAlreadyExistException("Merchant or Branch", "terminalId", request.getTerminalId());
        }
        var terminalAssignment = terminalAssignmentMapper.toEntity(request);
        var merchant = merchantFeignClient.getMerchantById(request.getMerchantId()).getBody();

        System.out.println( merchant.getMerchantCode());
        terminalAssignment.setMerchantId(merchant.getId());

        terminalAssignment = terminalAssignmentRepository.save(terminalAssignment);
        return terminalAssignmentMapper.toDto(terminalAssignment);
    }
}
