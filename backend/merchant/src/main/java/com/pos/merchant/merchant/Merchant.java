package com.pos.merchant.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.audit.BaseEntity;
import com.pos.merchant.category.MerchantCategory;
import com.pos.merchant.fee_profile.FeeProfile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Schema(
        name = "Merchant",
        description = "Schema to hold Merchant information"
)

@Getter
@Setter
@Entity
@Table(name = "merchants")
public class Merchant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_code", unique = true)
    @Schema(
            description = "Merchant Code of POS merchant", example = "MERCH-00001" // example value can be used for testing
    )
    private String merchantCode;

    @Column(name = "legal_name")
    @Schema(
            description = "Legal Name of POS merchant", example = "ET Supermarket" // example value can be used for testing
    )
    private String legalName;

    @Column(name = "trade_name")
    @Schema(
            description = "Trade Name of POS merchant", example = "ET Supermarket" // example value can be used for testing
    )
    private String tradeName;

    @Column(name = "tin_number")
    @Schema(
            description = "Tin Number of POS merchant", example = "1234567890" // example value can be used for testing
    )
    private String tinNumber;

    @Column(name = "business_license")
    @Schema(
            description = "Business License of POS merchant", example = "1234567890" // example value can be used for testing
    )
    private String businessLicense;

    @Column(name = "business_type")
    @Schema(
            description = "businessType of POS merchant", example = "1234567890" // example value can be used for testing
    )
    private String businessType;

    @Column(name = "region")
    @Schema(
            description = "Region of POS merchant", example = "Addis Ababa" // example value can be used for testing
    )
    private String region;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    @Schema(
            description = "Merchant Category of POS merchant", example = "supermarket" // example value can be used for testing
    )
    private MerchantCategory merchantCategory;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fee_profile_id")
    @Schema(
            description = "Fee Profile of POS merchant", example = "gold" // example value can be used for testing
    )
    private FeeProfile feeProfile;

    @Convert(converter = MerchantStatusConverter.class)
    @Column(name = "status")
    @Schema(
            description = "Status of POS merchant", example = "Active" // example value can be used for testing
    )
    private MerchantStatus status;

    @Column(name = "phone_number")
    @Schema(
            description = "Phone Number of POS merchant", example = "+251900000000" // example value can be used for testing
    )
    private String phoneNumber;

    @Column(name = "email")
    @Schema(
            description = "Email of POS merchant", example = "test@example.com" // example value can be used for testing
    )
    private String email;

    @Column(name = "website")
    @Schema(
            description = "Website of POS merchant", example = "https://test.com" // example value can be used for testing
    )
    private String website;

    @Column(name = "country")
    @Schema(
            description = "Country of POS merchant", example = "Ethiopia" // example value can be used for testing
    )
    private String country;

    @Column(name = "city")
    @Schema(
            description = "City of POS merchant", example = "Addis Ababa" // example value can be used for testing
    )
    private String city;

    @Column(name = "sub_city")
    @Schema(
            description = "Sub City of POS merchant", example = "Addis Ababa" // example value can be used for testing
    )
    private String subCity;

    @Column(name = "woreda")
    @Schema(
            description = "Woreda of POS merchant", example = "Bole" // example value can be used for testing
    )
    private String woreda;

    @Column(name = "address")
    @Schema(
            description = "Address of POS merchant", example = "Bole" // example value can be used for testing
    )
    private String address;

    @Column(name = "house_no")
    @Schema(
            description = "House No of POS merchant", example = "HN0001" // example value can be used for testing
    )
    private String houseNo;

    @Column(name = "version")
    @Version
    @Schema(
            description = "Version of POS merchant", example = "1" // example value can be used for testing
    )
    private Long version;
}
