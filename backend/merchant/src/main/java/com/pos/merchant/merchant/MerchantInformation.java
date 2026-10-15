package com.pos.merchant.merchant;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MerchantInformation {
    private Long id;
    private String merchantCode;
    private String legalName;
    private String tradeName;
    private String tinNumber;
    private String businessLicense;
    private String businessType;
    private String category;
    private Long branch;
    private String settlementAccount;
    private String feeProfile;
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
    private LocalDateTime createdAt;
}
