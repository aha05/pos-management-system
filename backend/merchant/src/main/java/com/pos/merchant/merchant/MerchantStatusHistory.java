package com.pos.merchant.merchant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "merchant_status_history")
public class MerchantStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "old_status")
    private String oldStatus;

    @Column(name = "new_status")
    private String newStatus;

    @Column(name = "changed_by")
    private String changedBy;

    @Column(name = "changed_at", insertable = false)
    private LocalDateTime changedAt;

    @Column(name = "reason")
    private String reason;
}
