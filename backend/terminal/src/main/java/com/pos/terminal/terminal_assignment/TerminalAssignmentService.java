package com.pos.terminal.terminal_assignment;

import com.pos.terminal.common.InvalidOperationException;
import com.pos.terminal.common.ResourceAlreadyExistException;
import com.pos.terminal.common.ResourceNotFoundException;
import com.pos.terminal.terminal_assignment.client.BranchDto;
import com.pos.terminal.terminal_assignment.client.MerchantDto;
import com.pos.terminal.terminal_assignment.client.MerchantFeignClient;
import feign.FeignException;
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
            throw new ResourceAlreadyExistException("Terminal Assignment", "terminalId", request.getTerminalId());
        }


        var merchant = getMerchantOrThrow(request.getMerchantId());
        var branch = getBranchOrThrow(request.getBranchId());

        if (!branch.getMerchantId().equals(merchant.getId())) {
            throw new InvalidOperationException(
                    "The specified branch does not belong to the selected merchant.");
        }

        var terminalAssignment = terminalAssignmentMapper.toEntity(request);
        terminalAssignment.setMerchantId(merchant.getId());
        terminalAssignment.setBranchId(branch.getId());

        terminalAssignment = terminalAssignmentRepository.save(terminalAssignment);
        return terminalAssignmentMapper.toDto(terminalAssignment);
    }

    private MerchantDto getMerchantOrThrow(Long merchantId) {
        try {
            MerchantDto merchant = merchantFeignClient
                    .getMerchantById(merchantId)
                    .getBody();

            if (merchant == null) {
                throw new ResourceNotFoundException(
                        "Merchant", "merchantId", merchantId);
            }

            return merchant;
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException(
                    "Merchant", "merchantId", merchantId);
        }
    }

    private BranchDto getBranchOrThrow(Long branchId) {
        try {
            BranchDto branch = merchantFeignClient
                    .getBranchById(branchId)
                    .getBody();

            if (branch == null) {
                throw new ResourceNotFoundException(
                        "Branch", "branchId", branchId);
            }

            return branch;
        } catch (FeignException.NotFound ex) {
            throw new ResourceNotFoundException(
                    "Branch", "branchId", branchId);
        }
    }
}
