package com.pos.merchant.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<MerchantCategory, Long> {
}
