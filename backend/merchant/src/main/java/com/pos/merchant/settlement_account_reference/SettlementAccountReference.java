package com.pos.merchant.settlement_account_reference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.audit.BaseEntity;
import com.pos.merchant.merchant.Merchant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "settlement_account_reference")
public class SettlementAccountReference extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "currency")
    private String currency;

    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "account_service_reference_id")
    private String accountServiceReferenceId;
}
