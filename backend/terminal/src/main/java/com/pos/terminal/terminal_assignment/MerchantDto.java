package com.pos.terminal.terminal_assignment;

import lombok.Data;

@Data
public class MerchantDto {
    private Long id;
    private String merchantCode;
    private String legalName;
    private String tradeName;
    private String tinNumber;
    private String businessLicense;
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
