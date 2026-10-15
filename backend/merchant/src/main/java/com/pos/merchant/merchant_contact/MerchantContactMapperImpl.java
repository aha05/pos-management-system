package com.pos.merchant.merchant_contact;

import com.pos.merchant.merchant.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchantContactMapperImpl implements MerchantContactMapper {
    private final MerchantService merchantService;

    @Override
    public MerchantContactResponse toDto(MerchantContact merchantContact) {
        return MerchantContactResponse.builder()
                .id(merchantContact.getId())
                .merchantId(merchantContact.getMerchant().getId())
                .fullName(merchantContact.getFullName())
                .designation(merchantContact.getDesignation())
                .phoneNumber(merchantContact.getPhoneNumber())
                .email(merchantContact.getEmail())
                .primaryContact(merchantContact.getPrimaryContact())
                .build();
    }

    @Override
    public MerchantContact toEntity(MerchantContactRequest request) {
        MerchantContact merchantContact = new MerchantContact();
        merchantContact.setMerchant(merchantService
                .findMerchantById(request.getMerchantId()));
        merchantContact.setFullName(request.getFullName());
        merchantContact.setDesignation(request.getDesignation());
        merchantContact.setPhoneNumber(request.getPhoneNumber());
        merchantContact.setEmail(request.getEmail());
        merchantContact.setPrimaryContact(request.getPrimaryContact());
        return merchantContact;
    }
}
