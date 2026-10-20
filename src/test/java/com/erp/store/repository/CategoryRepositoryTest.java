package com.erp.store.repository;

import com.erp.store.entity.Category;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Disabled
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findByDescriptionContaining_DeberiaRetornarCategoriasFiltradas() {
        // --- ARRANGE ---
        // Insertamos datos reales en la base de datos temporal
        Category cat1 = Category.builder().CategoryName("Licuados").Description("Licuados Locos").build();
        Category cat2 = Category.builder().CategoryName("Sodas").Description("Bebidas con gas").build();
        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        // --- ACT ---
        // Ejecutamos la consulta real contra la base de datos
        List<Category> resultado = categoryRepository.findByDescriptionContaining("Locos");

        // --- ASSERT ---
        // Verificamos que la base de datos haya filtrado correctamente
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getCategoryName()).isEqualTo("Licuados");
    } // <-- Aquí Spring hace ROLLBACK automáticamente. La DB queda vacía de nuevo.
}