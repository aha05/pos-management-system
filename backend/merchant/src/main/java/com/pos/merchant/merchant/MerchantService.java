package com.pos.merchant.merchant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;

    public List<MerchantResponse> getMerchants() {
        return merchantRepository.findAll()
                .stream()
                .map(merchantMapper::toDto)
                .toList();
    }

    public MerchantResponse addMerchant(MerchantRequest request) {
        var merchant = merchantRepository.save(merchantMapper
                .toEntity(request));
        return merchantMapper.toDto(merchant);

    }
}