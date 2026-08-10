package com.pos.merchant.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.audit.BaseEntity;
import com.pos.merchant.category.MerchantCategory;
import com.pos.merchant.fee_profile.FeeProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "merchants")
public class Merchant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_code", unique = true)
    private String merchantCode;

    @Column(name = "legal_name")
    private String legalName;

    @Column(name = "trade_name")
    private String tradeName;

    @Column(name = "tin_number")
    private String tinNumber;

    @Column(name = "business_license")
    private String businessLicense;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private MerchantCategory merchantCategory;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fee_profile_id")
    private FeeProfile feeProfile;

    @Convert(converter = MerchantStatusConverter.class)
    @Column(name = "status")
    private MerchantStatus status;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

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

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "version")
    @Version
    private Long version;
}
