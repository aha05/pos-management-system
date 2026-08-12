package com.pos.merchant.category;

import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryResponse toDto(MerchantCategory merchantCategory) {
        return CategoryResponse.builder()
                .id(merchantCategory.getId())
                .categoryCode(merchantCategory.getCategoryCode())
                .categoryName(merchantCategory.getCategoryName())
                .description(merchantCategory.getDescription())
                .active(merchantCategory.getActive())
                .build();
    }

    @Override
    public MerchantCategory toEntity(CategoryRequest request) {
        MerchantCategory merchantCategory = new MerchantCategory();
        merchantCategory.setCategoryCode(request.getCategoryCode());
        merchantCategory.setCategoryName(request.getCategoryName());
        merchantCategory.setActive(request.getActive());
        merchantCategory.setDescription(request.getDescription());

        return merchantCategory;
    }
}
