package com.pos.terminal.terminal_assignment.client;

import com.pos.terminal.terminal_assignment.CategoryDto;
import com.pos.terminal.terminal_assignment.MerchantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("merchant")
public interface MerchantFeignClient {
    @GetMapping(value = "/merchant/{id}",consumes = "application/json")
    public ResponseEntity<MerchantDto> getMerchantById(@PathVariable(name = "id") Long merchantId);

    @GetMapping(value = "/merchant/category/{id}",consumes = "application/json")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") Long categoryId);
}
