package com.pos.terminal.terminal_assignment.client;

import lombok.Data;

@Data
public class BranchDto {
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
}
