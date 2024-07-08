package com.axa.productmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.axa.productmanagement.models.Product;
import com.axa.productmanagement.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setName("Test Product");
        
        Mockito.when(productRepository.save(product)).thenReturn(product);
        
        assertEquals(product, productService.createProduct(product));
    }
}
