package com.pos.merchant.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant-category")
@RequiredArgsConstructor
public class MerchantCategoryController {
    private final MerchantCategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantCategoryResponse> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantCategoryResponse addCategory(@Valid @RequestBody MerchantCategoryRequest request) {
        return categoryService.addCategory(request);
    }
}
