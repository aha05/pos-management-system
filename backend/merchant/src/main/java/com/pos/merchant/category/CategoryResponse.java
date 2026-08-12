package com.pos.merchant.category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryResponse {
    private Long id;
    private String categoryCode;
    private String categoryName;
    private String description;
    private Boolean active;
}
