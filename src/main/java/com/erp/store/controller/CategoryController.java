package com.erp.store.controller;

import com.erp.store.entity.Category;
import com.erp.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> categoriesList = categoryService.allCategories();
        return ResponseEntity.ok(categoriesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable int id) {
        try {
            Category category = categoryService.findCategoryById(id);
            return ResponseEntity.ok(category);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        try {
            Category categoryCreated = categoryService.create(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryCreated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
