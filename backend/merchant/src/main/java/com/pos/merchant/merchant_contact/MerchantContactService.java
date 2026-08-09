package com.pos.merchant.merchant_contact;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantContactService {
    private final MerchantContactRepository merchantContactRepository;
    private final MerchantContactMapper merchantContactMapper;

    public List<MerchantContactResponse> getMerchantContacts() {
        return merchantContactRepository.findAll()
                .stream()
                .map(merchantContactMapper::toDto)
                .toList();
    }

    public MerchantContactResponse addMerchantContact(MerchantContactRequest request) {
        var merchantContact = merchantContactMapper.toEntity(request);
        merchantContactRepository.save(merchantContact);
        return merchantContactMapper.toDto(merchantContact);
    }
}
