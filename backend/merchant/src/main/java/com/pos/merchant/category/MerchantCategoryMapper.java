package com.pos.merchant.category;

public interface MerchantCategoryMapper {
    MerchantCategoryResponse toDto(MerchantCategory merchantCategory);
    MerchantCategory toEntity(MerchantCategoryRequest request);
}
