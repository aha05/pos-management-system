package com.pos.merchant.branch;

public interface MerchantBranchMapper {
    MerchantBranchResponse toDto(MerchantBranch merchantBranch);
    MerchantBranch toEntity(MerchantBranchRequest request);
}
