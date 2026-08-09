package com.pos.merchant.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantBranchService {
    private final MerchantBranchRepository merchantBranchRepository;
    private final MerchantBranchMapper merchantBranchMapper;

    public List<MerchantBranchResponse> getMerchantBranches() {
        return merchantBranchRepository.findAll()
                .stream()
                .map(merchantBranchMapper::toDto)
                .toList();
    }

    public MerchantBranchResponse addMerchantBranch(MerchantBranchRequest request) {
        var merchantBranch = merchantBranchMapper.toEntity(request);
        merchantBranchRepository.save(merchantBranch);
        return merchantBranchMapper.toDto(merchantBranch);
    }
}
