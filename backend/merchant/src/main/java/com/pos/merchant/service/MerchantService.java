package com.pos.merchant.service;

import com.pos.merchant.dto.MerchantRequest;
import com.pos.merchant.dto.MerchantResponse;
import com.pos.merchant.entity.Merchant;
import com.pos.merchant.mapper.IMerchantMapper;
import com.pos.merchant.repository.MerchantRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;
    private final IMerchantMapper iMerchantMapper;

    public List<MerchantResponse> getMerchants() {
        return merchantRepository.findAll()
                .stream()
                .map(iMerchantMapper::toDto)
                .toList();
    }

    public MerchantResponse addMerchant(MerchantRequest request) {
        var merchant = merchantRepository.save(iMerchantMapper
                .toEntity(request));
        return iMerchantMapper.toDto(merchant);

    }
}