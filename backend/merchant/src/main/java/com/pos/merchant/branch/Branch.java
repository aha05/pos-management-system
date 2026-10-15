package com.pos.merchant.branch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.audit.BaseEntity;
import com.pos.merchant.merchant.Merchant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "merchant_branch")
public class MerchantBranch extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "branch_code", unique = true)
    private String branchCode;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "sub_city")
    private String subCity;

    @Column(name = "woreda")
    private String woreda;

    @Column(name = "address")
    private String address;

    @Convert(converter = BranchStatusConverter.class)
    @Column(name = "status")
    private BranchStatus status;
}
