package com.pos.merchant.merchant;

public interface MerchantMapper {
    MerchantResponse toDto(Merchant merchant);
    Merchant toEntity(MerchantRequest request);
}
