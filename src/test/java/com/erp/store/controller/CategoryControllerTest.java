package com.erp.store.controller;

import com.erp.store.entity.Category;
import com.erp.store.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CategoryService categoryService;

    @Test
    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
    void findCategoryById_May_Return_Status_200_And_Category() throws Exception {
        // Arrange
        int idCategory = 1;
        Category categorySimulated = Category.builder().CategoryID(idCategory).CategoryName("Licuados").Description("Licuados Locos").build();

        when(categoryService.findCategoryById(idCategory)).thenReturn(categorySimulated);

        // Act & Assert
        mockMvc.perform(get("/api/categories/" + idCategory)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.CategoryID").value(idCategory));
    }
}