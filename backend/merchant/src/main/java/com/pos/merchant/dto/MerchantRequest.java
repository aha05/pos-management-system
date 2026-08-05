package com.pos.merchant.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class MerchantRequest {
    private String firstName;
    private String lastName;
}
