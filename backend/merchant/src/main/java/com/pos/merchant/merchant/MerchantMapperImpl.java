package com.pos.merchant.merchant;

import com.pos.merchant.category.MerchantCategory;
import com.pos.merchant.category.MerchantCategoryRepository;
import com.pos.merchant.fee_profile.FeeProfile;
import com.pos.merchant.fee_profile.FeeProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchantMapperImpl implements MerchantMapper {
    private final MerchantCategoryRepository merchantCategoryRepository;
    private final FeeProfileRepository feeProfileRepository;

    @Override
    public MerchantResponse toDto(Merchant merchant) {
        return MerchantResponse.builder()
                .id(merchant.getId())
                .merchantCode(merchant.getMerchantCode())
                .legalName(merchant.getLegalName())
                .tradeName(merchant.getTradeName())
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
        merchant.setMerchantCategory(
                getMerchantCategoryById(request.getMerchantCategoryId()));
        merchant.setFeeProfile(
                getFeeProfileById(request.getFeeProfileId()));
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

   MerchantCategory getMerchantCategoryById (Long categoryId) {
     return merchantCategoryRepository.findById(categoryId).orElse(null);
   }

    FeeProfile getFeeProfileById (Long categoryId) {
        return feeProfileRepository.findById(categoryId).orElse(null);
    }
}