package com.erp.store.service;

import com.erp.store.entity.Category;
import com.erp.store.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(int idCategory) {
        return categoryRepository.findById(idCategory)
                .orElseThrow(() -> new IllegalArgumentException("Category does not exists."));
    }

    @Transactional
    public Category create(Category category) {
        if(category.getCategoryID() != 0) throw new IllegalArgumentException("Para crear un producto nuevo, el ID debe ser 0.");

        return categoryRepository.save(category);
    }
}
