package com.pos.merchant.category;

import org.springframework.stereotype.Component;

@Component
public class MerchantCategoryMapperImpl implements MerchantCategoryMapper {
    @Override
    public MerchantCategoryResponse toDto(MerchantCategory merchantCategory) {
        return MerchantCategoryResponse.builder()
                .id(merchantCategory.getId())
                .categoryCode(merchantCategory.getCategoryName())
                .categoryName(merchantCategory.getCategoryName())
                .description(merchantCategory.getDescription())
                .active(merchantCategory.getActive())
                .build();
    }

    @Override
    public MerchantCategory toEntity(MerchantCategoryRequest request) {
        MerchantCategory merchantCategory = new MerchantCategory();
        merchantCategory.setCategoryCode(request.getCategoryCode());
        merchantCategory.setCategoryName(request.getCategoryName());
        merchantCategory.setActive(request.getActive());
        merchantCategory.setDescription(request.getDescription());

        return merchantCategory;
    }
}
