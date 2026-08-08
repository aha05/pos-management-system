package com.pos.merchant.merchant;

import org.springframework.stereotype.Component;

@Component
public class MerchantMapperImpl implements MerchantMapper {

    @Override
    public MerchantResponse toDto(Merchant merchant) {
        return MerchantResponse.builder()
                .id(merchant.getId())
                .merchantCode(merchant.getMerchantCode())
                .legalName(merchant.getLegalName())
                .tinNumber(merchant.getTinNumber())
                .businessLicense(merchant.getBusinessLicense())
                .merchantCategory(merchant.getMerchantCategory())
                .feeProfile(merchant.getFeeProfile())
                .status(merchant.getStatus())
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
        merchant.setMerchantCategory(request.getMerchantCategory());
        merchant.setFeeProfile(request.getFeeProfile());
        merchant.setStatus(request.getStatus());
        merchant.setPhoneNumber(request.getPhoneNumber());
        merchant.setEmail(request.getEmail());
        merchant.setWebsite(request.getWebsite());
        merchant.setCountry(request.getCountry());
        merchant.setCountry(request.getCountry());
        merchant.setSubCity(request.getSubCity());
        merchant.setWoreda(request.getWoreda());
        merchant.setAddress(request.getAddress());
        merchant.setHouseNo(request.getHouseNo());

        return merchant;
    }
}