package com.pos.merchant.branch;

import com.pos.merchant.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchMapperImpl implements BranchMapper {
    private final MerchantService merchantService;

    @Override
    public BranchResponse toDto(Branch branch) {
        return BranchResponse.builder()
                .id(branch.getId())
                .merchantId(branch.getMerchant().getId())
                .branchCode(branch.getBranchCode())
                .branchName(branch.getBranchName())
                .phoneNumber(branch.getPhoneNumber())
                .email(branch.getEmail())
                .country(branch.getCountry())
                .city(branch.getCity())
                .city(branch.getCity())
                .subCity(branch.getCity())
                .woreda(branch.getWoreda())
                .address(branch.getAddress())
                .status(branch.getStatus())
                .build();
    }

    @Override
    public Branch toEntity(BranchRequest request) {
        Branch merchantBranch = new Branch();
        merchantBranch.setMerchant(merchantService
                .findMerchantById(request.getMerchantId()));
        merchantBranch.setBranchCode(request.getBranchCode());
        merchantBranch.setBranchName(request.getBranchName());
        merchantBranch.setPhoneNumber(request.getPhoneNumber());
        merchantBranch.setEmail(request.getEmail());
        merchantBranch.setCountry(request.getCountry());
        merchantBranch.setCity(request.getCity());
        merchantBranch.setSubCity(request.getSubCity());
        merchantBranch.setWoreda(request.getWoreda());
        merchantBranch.setAddress(request.getAddress());
        merchantBranch.setStatus(request.getStatus());
        return merchantBranch;
    }
}
