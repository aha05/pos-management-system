package com.pos.merchant.branch;

import com.pos.merchant.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchantBranchMapperImpl implements MerchantBranchMapper {
    private final MerchantService merchantService;

    @Override
    public MerchantBranchResponse toDto(MerchantBranch merchantBranch) {
        return MerchantBranchResponse.builder()
                .id(merchantBranch.getId())
                .merchantId(merchantBranch.getMerchant().getId())
                .branchCode(merchantBranch.getBranchCode())
                .branchName(merchantBranch.getBranchName())
                .phoneNumber(merchantBranch.getPhoneNumber())
                .email(merchantBranch.getEmail())
                .country(merchantBranch.getCountry())
                .city(merchantBranch.getCity())
                .city(merchantBranch.getCity())
                .subCity(merchantBranch.getCity())
                .woreda(merchantBranch.getWoreda())
                .address(merchantBranch.getAddress())
                .status(merchantBranch.getStatus())
                .build();
    }

    @Override
    public MerchantBranch toEntity(MerchantBranchRequest request) {
        MerchantBranch merchantBranch = new MerchantBranch();
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
