package com.pos.merchant.category;

public interface MerchantCategoryMapper {
    public MerchantCategoryResponse toDto(MerchantCategory merchantCategory);
    public MerchantCategory toEntity(MerchantCategoryRequest request);
}
