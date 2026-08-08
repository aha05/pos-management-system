package com.pos.merchant.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantCategoryService {
    private final MerchantCategoryRepository merchantCategoryRepository;
    private final MerchantCategoryMapper merchantCategoryMapper;

    public List<MerchantCategoryResponse> getCategories() {
        return merchantCategoryRepository.findAll()
                .stream()
                .map(merchantCategoryMapper::toDto)
                .toList();
    }
    public MerchantCategoryResponse addCategory(MerchantCategoryRequest request) {
        var merchantCategory = merchantCategoryRepository.save(merchantCategoryMapper.toEntity(request));
        return merchantCategoryMapper.toDto(merchantCategory);
    }
}
