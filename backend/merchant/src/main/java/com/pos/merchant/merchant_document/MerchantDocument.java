package com.pos.merchant.merchant_document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos.merchant.merchant.Merchant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "merchant_document")
public class MerchantDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "storage_path")
    private String storagePath;

    @Column(name = "verified")
    private Boolean verified;
}
