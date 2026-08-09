package com.pos.merchant.merchant_contact;

import com.pos.merchant.merchant.Merchant;
import com.pos.merchant.merchant.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchantContactMapperImpl implements MerchantContactMapper {
    private final MerchantRepository merchantRepository;

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
        merchantContact.setMerchant(
                getMerchantById(request.getMerchantId()));
        merchantContact.setDesignation(request.getDesignation());
        merchantContact.setPhoneNumber(merchantContact.getPhoneNumber());
        merchantContact.setEmail(merchantContact.getEmail());
        merchantContact.setPrimaryContact(merchantContact.getPrimaryContact());
        return merchantContact;
    }

    public Merchant getMerchantById(Long merchantId){
        return merchantRepository.findById(merchantId).orElse(null);
    }
}
