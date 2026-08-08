package com.pos.merchant.fee_profile;

import com.pos.merchant.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "fee_profile")
public class FeeProfile extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_code")
    private String profileCode;

    @Column(name = "profile_name")
    private String profileName;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_fee_type")
    private FeeType transactionFeeType;

    @Column(name = "transaction_fee", precision = 10, scale = 2)
    private BigDecimal transactionFee;

    @Column(name = "minimum_fee", precision = 10, scale = 2)
    private BigDecimal minimumFee;

    @Column(name = "maximum_fee", precision = 10, scale = 2)
    private BigDecimal maximumFee;

    @Enumerated(EnumType.STRING)
    @Column(name = "settlement_fee_type")
    private FeeType settlementFeeType;

    @Column(name = "settlement_fee_value", precision = 10, scale = 2)
    private BigDecimal settlementFeeValue;

    @Column(name = "currency")
    private String currency;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "version")
    @Version
    private Long version;
}
