package com.pos.merchant.branch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MerchantBranchRequest {
    @NotNull(message = "Merchant Id is mandatory")
    private Long merchantId;

    @NotBlank(message = "Branch Code is mandatory")
    private String branchCode;

    @NotBlank(message = "Branch Name is mandatory")
    private String branchName;

    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Sub City is mandatory")
    private String subCity;

    @NotBlank(message = "Woreda is mandatory")
    private String woreda;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotNull(message = "Status is mandatory")
    private BranchStatus status;
}
