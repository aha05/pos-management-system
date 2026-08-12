package com.pos.merchant.merchant;

import com.pos.merchant.category.CategoryService;
import com.pos.merchant.fee_profile.FeeProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchantMapperImpl implements MerchantMapper {
    private final CategoryService categoryService;
    private final FeeProfileService feeProfileService;

    @Override
    public MerchantResponse toDto(Merchant merchant) {
        return MerchantResponse.builder()
                .id(merchant.getId())
                .merchantCode(merchant.getMerchantCode())
                .legalName(merchant.getLegalName())
                .tradeName(merchant.getTradeName())
                .tinNumber(merchant.getTinNumber())
                .businessLicense(merchant.getBusinessLicense())
                .categoryId(merchant.getMerchantCategory().getId())
                .feeProfileId(merchant.getFeeProfile().getId())
                .status(merchant.getStatus().toString())
                .phoneNumber(merchant.getPhoneNumber())
                .email(merchant.getEmail())
                .website(merchant.getWebsite())
                .country(merchant.getCountry())
                .city(merchant.getCity())
                .subCity(merchant.getSubCity())
                .woreda(merchant.getWoreda())
                .address(merchant.getAddress())
                .houseNo(merchant.getHouseNo())
                .build();
    }

    @Override
    public Merchant toEntity(MerchantRequest request) {
        var merchant = new Merchant();
        merchant.setMerchantCode(request.getMerchantCode());
        merchant.setLegalName(request.getLegalName());
        merchant.setTradeName(request.getTradeName());
        merchant.setTinNumber(request.getTinNumber());
        merchant.setBusinessLicense(request.getBusinessLicense());
        merchant.setMerchantCategory(categoryService
                .findCategoryById(request.getMerchantCategoryId()));
        merchant.setFeeProfile(feeProfileService
                .findFeeProfileById(request.getFeeProfileId()));
        merchant.setStatus(request.getStatus());
        merchant.setPhoneNumber(request.getPhoneNumber());
        merchant.setEmail(request.getEmail());
        merchant.setWebsite(request.getWebsite());
        merchant.setCountry(request.getCountry());
        merchant.setCountry(request.getCountry());
        merchant.setCity(request.getCity());
        merchant.setSubCity(request.getSubCity());
        merchant.setWoreda(request.getWoreda());
        merchant.setAddress(request.getAddress());
        merchant.setHouseNo(request.getHouseNo());

        return merchant;
    }
}