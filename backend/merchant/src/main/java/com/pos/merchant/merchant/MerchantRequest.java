package com.pos.merchant.merchant;

import com.pos.merchant.category.MerchantCategory;
import com.pos.merchant.fee_profile.FeeProfile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MerchantRequest {
    @NotBlank(message = "Merchant Code is mandatory")
    private String merchantCode;

    @NotBlank(message = "Legal Name is mandatory")
    private String legalName;

    @NotBlank(message = "Trade Name is mandatory")
    private String tradeName;

    @NotBlank(message = "Tin Number is mandatory")
    private String tinNumber;

    @NotBlank(message = "Business License is mandatory")
    private String businessLicense;

    @NotNull(message = "Merchant Category is mandatory")
    private MerchantCategory merchantCategory;

    @NotNull(message = "Fee Profile is mandatory")
    private FeeProfile feeProfile;

    @NotNull(message = "Status is mandatory")
    private Long status;

    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Website is mandatory")
    private String website;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "SubCity is mandatory")
    private String subCity;

    @NotBlank(message = "Woreda is mandatory")
    private String woreda;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "HouseNo is mandatory")
    private String houseNo;
}
