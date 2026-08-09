package com.pos.merchant.merchant_contact;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MerchantContactRequest {
    @NotNull(message = "Merchant Id is mandatoy")
    private Long merchantId;

    @NotBlank(message = "Full Name is mandatory")
    private String fullName;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotBlank(message = "Phone Number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Primary Contact is mandatory")
    private Boolean primaryContact;
}
