package com.pos.merchant.merchant;

public interface MerchantMapper {
    public MerchantResponse toDto(Merchant merchant);
    public Merchant toEntity(MerchantRequest request);
}
