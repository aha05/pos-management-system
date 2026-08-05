package com.pos.merchant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantResponse {
    private Long id;
    private String firstName;
    private String lastName;
}
