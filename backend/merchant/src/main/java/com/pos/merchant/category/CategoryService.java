package com.pos.merchant.category;

import com.pos.merchant.common.ResourceNotFoundException;
import com.pos.merchant.merchant.MerchantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public MerchantCategory findCategoryById (Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId)
        );
    }

    public List<CategoryResponse> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }
    public CategoryResponse addCategory(CategoryRequest request) {
        var merchantCategory = categoryRepository.save(categoryMapper.toEntity(request));
        return categoryMapper.toDto(merchantCategory);
    }

    public CategoryResponse getCategoryById(Long categoryId) {
        var category =  categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "categoryId", categoryId)
        );
        return categoryMapper.toDto(category);
    }
}
