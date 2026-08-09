package com.pos.merchant.merchant_contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.merchant.Merchant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "merchant_contact")
public class MerchantContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "primary_contact")
    private Boolean primaryContact;

}
