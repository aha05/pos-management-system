package com.pos.merchant.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant-category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@Valid @RequestBody CategoryRequest request) {
        return categoryService.addCategory(request);
    }
}
