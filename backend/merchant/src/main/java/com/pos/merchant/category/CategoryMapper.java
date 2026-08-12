package com.pos.merchant.category;

public interface CategoryMapper {
    CategoryResponse toDto(MerchantCategory merchantCategory);
    MerchantCategory toEntity(CategoryRequest request);
}
