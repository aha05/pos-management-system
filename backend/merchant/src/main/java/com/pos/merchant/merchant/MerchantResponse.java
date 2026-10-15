package com.pos.merchant.merchant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MerchantResponse {
    private Long id;
    private String merchantCode;
    private String legalName;
    private String tradeName;
    private String tinNumber;
    private String businessLicense;
    private String businessType;
    private Long categoryId;
    private Long feeProfileId;
    private String status;
    private String phoneNumber;
    private String email;
    private String website;
    private String country;
    private String city;
    private String subCity;
    private String woreda;
    private String address;
    private String houseNo;
}
