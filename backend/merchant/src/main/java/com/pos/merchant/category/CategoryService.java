package com.pos.merchant.category;

import com.pos.merchant.common.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper merchantCategoryMapper;

    public MerchantCategory findCategoryById (Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId)
        );
    }

    public List<CategoryResponse> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(merchantCategoryMapper::toDto)
                .toList();
    }
    public CategoryResponse addCategory(CategoryRequest request) {
        var merchantCategory = categoryRepository.save(merchantCategoryMapper.toEntity(request));
        return merchantCategoryMapper.toDto(merchantCategory);
    }
}
