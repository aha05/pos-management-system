package com.pos.merchant.merchant;

import com.pos.merchant.category.MerchantCategory;
import com.pos.merchant.fee_profile.FeeProfile;
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
    private MerchantCategory merchantCategory;
    private FeeProfile feeProfile;
    private Long status;
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
