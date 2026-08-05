package com.pos.merchant.mapper;

import com.pos.merchant.dto.MerchantRequest;
import com.pos.merchant.dto.MerchantResponse;
import com.pos.merchant.entity.Merchant;

import java.util.List;

public interface IMerchantMapper{
    public MerchantResponse toDto(Merchant merchant);
    public Merchant toEntity(MerchantRequest request);
}
