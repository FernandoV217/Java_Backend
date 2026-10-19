package com.erp.store.service;


import com.erp.store.entity.Category;
import com.erp.store.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    void findCategoryById_When_Exists_May_Return_Category() {
        // Arrange
        int idCategory = 1;
        byte[] testImage = new byte[0];
        Category categorySimulated = Category.builder().CategoryID(idCategory).CategoryName("Licuados").Description("Licuados Locos").build();

        when(categoryRepository.findById(idCategory)).thenReturn(Optional.of(categorySimulated));

        // Act
        Category resultado = categoryService.findCategoryById(idCategory);

        // Assert
        assertThat(resultado).isEqualTo(categorySimulated);
    }

    @Test
    void findCategoryById_When_Does_Not_Exists_May_Throw_NoSuchElementException() {
        // Arrange
        int idCategory = 1;

        when(categoryRepository.findById(idCategory)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> categoryService.findCategoryById(idCategory))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Category does not exists.");
    }
}
