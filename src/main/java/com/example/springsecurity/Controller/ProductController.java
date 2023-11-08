package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Product;
import com.example.springsecurity.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@PreAuthorize("hasRole('SUPER')")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @PreAuthorize("hasAnyRole('GEN','ADMIN','SUPER')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SUPER','MANG')")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER','ADMIN','MANG')")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER','ADMIN','MANG')")
    public Product editProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return productService.editProduct(product);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER','ADMIN')")
    public Product deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
