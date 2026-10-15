package com.pos.merchant.branch;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MerchantBranchResponse {
    private Long id;
    private Long merchantId;
    private String branchCode;
    private String branchName;
    private String phoneNumber;
    private String email;
    private String country;
    private String city;
    private String subCity;
    private String woreda;
    private String address;
    private BranchStatus status;
}
