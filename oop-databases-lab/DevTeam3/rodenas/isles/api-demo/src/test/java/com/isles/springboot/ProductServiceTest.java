package com.isles.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.isles.springboot.dto.CreateProductRequest;
import com.isles.springboot.dto.UpdateProductRequest;
import com.isles.springboot.entity.Product;
import com.isles.springboot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void shouldCreateAndUpdateProduct() {
        CreateProductRequest createRequest = new CreateProductRequest();
        createRequest.setName("Keyboard");
        createRequest.setDescription("Mechanical keyboard");
        createRequest.setPrice(2499.50);
        createRequest.setCategory("Electronics");
        createRequest.setStockQuantity(10);

        Product createdProduct = productService.createProduct(createRequest);
        assertNotNull(createdProduct.getId());
        assertEquals("Keyboard", createdProduct.getName());

        UpdateProductRequest updateRequest = new UpdateProductRequest();
        updateRequest.setPrice(1999.50);

        Product updatedProduct = productService.updateProduct(createdProduct.getId(), updateRequest);
        assertEquals(1999.50, updatedProduct.getPrice());
    }
}
