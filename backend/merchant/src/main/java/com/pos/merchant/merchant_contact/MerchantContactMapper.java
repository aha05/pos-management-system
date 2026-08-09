package com.pos.merchant.merchant_contact;

public interface MerchantContactMapper {
    MerchantContactResponse toDto(MerchantContact merchantContact);
    MerchantContact toEntity(MerchantContactRequest request);
}
