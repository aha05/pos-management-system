package com.pos.merchant.merchant;

import com.pos.merchant.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;

    public Merchant findMerchantById(Long merchantId){
        return merchantRepository.findById(merchantId).orElseThrow(
                () -> new ResourceNotFoundException("Merchant", "merchantId", merchantId)
        );
    }

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