package com.pos.merchant.branch;

import com.pos.merchant.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public BranchResponse getBranchById(Long branchId) {
        var branch = branchRepository.findById(branchId).orElseThrow(
                () -> new ResourceNotFoundException("Branch", "branchId", branchId)
        );
        return branchMapper.toDto(branch);
    }

    public List<BranchResponse> getBranches() {
        return branchRepository.findAll()
                .stream()
                .map(branchMapper::toDto)
                .toList();
    }

    public BranchResponse addBranch(BranchRequest request) {
        var merchantBranch = branchMapper.toEntity(request);
        branchRepository.save(merchantBranch);
        return branchMapper.toDto(merchantBranch);
    }
}
