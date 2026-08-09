package com.pos.merchant.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.fee_profile.FeeProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "merchant_fee_profile_history")
public class MerchantFeeProfileHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fee_profile_id")
    private FeeProfile feeProfile;

    @Column(name = "effective_from")
    private LocalDateTime effectiveFrom;

    @Column(name = "effective_to")
    private LocalDateTime effectiveTo;

    @Column(name = "assigned_by")
    private String  assignedBy;

    @Column(name = "remarks")
    private String remarks;
}
