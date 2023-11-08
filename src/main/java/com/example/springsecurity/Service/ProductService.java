package com.example.springsecurity.Service;

import java.util.List;

import com.example.springsecurity.Entity.Product;


public interface ProductService {
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public Product editProduct(Product product);
    public Product deleteProduct(long id);
    public Product getProductById(long id);
}
