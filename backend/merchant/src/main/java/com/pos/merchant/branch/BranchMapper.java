package com.pos.merchant.branch;

public interface BranchMapper {
    BranchResponse toDto(Branch branch);
    Branch toEntity(BranchRequest request);
}
