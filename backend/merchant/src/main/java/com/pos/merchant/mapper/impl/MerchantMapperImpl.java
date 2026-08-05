package com.pos.merchant.mapper.impl;

import com.pos.merchant.dto.MerchantRequest;
import com.pos.merchant.dto.MerchantResponse;
import com.pos.merchant.entity.Merchant;
import com.pos.merchant.mapper.IMerchantMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantMapperImpl implements IMerchantMapper {

    @Override
    public MerchantResponse toDto(Merchant merchant) {
        return MerchantResponse.builder()
                .firstName(merchant.getFirstName())
                .lastName(merchant.getLastName())
                .build();
    }

    @Override
    public Merchant toEntity(MerchantRequest request) {
        var merchant = new Merchant();
        merchant.setFirstName(request.getFirstName());
        merchant.setLastName(request.getLastName());
        return merchant;
    }
}