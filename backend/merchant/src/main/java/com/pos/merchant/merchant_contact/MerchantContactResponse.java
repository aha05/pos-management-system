package com.pos.merchant.merchant_contact;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MerchantContactResponse {
    private Long id;
    private Long merchantId;
    private String fullName;
    private String designation;
    private String phoneNumber;
    private String email;
    private Boolean primaryContact;
}
