package com.pos.merchant.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public List<BranchResponse> getMerchantBranches() {
        return branchRepository.findAll()
                .stream()
                .map(branchMapper::toDto)
                .toList();
    }

    public BranchResponse addMerchantBranch(BranchRequest request) {
        var merchantBranch = branchMapper.toEntity(request);
        branchRepository.save(merchantBranch);
        return branchMapper.toDto(merchantBranch);
    }
}
