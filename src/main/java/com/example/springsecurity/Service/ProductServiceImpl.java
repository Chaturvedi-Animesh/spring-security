package com.example.springsecurity.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Entity.Product;
import com.example.springsecurity.Repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo repo;

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product editProduct(Product product) {
        Product existingProduct = repo.findById(product.getId()).orElse(null);
        if (existingProduct != null) {

            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());

            return repo.save(existingProduct);
        } else {

            throw new NoSuchElementException("Product not found with id: " + product.getId());
        }
    }

    @Override
    public Product deleteProduct(long id) {
        Product productToDelete = repo.findById(id).orElse(null);
        if (productToDelete != null) {
            repo.delete(productToDelete);
            return productToDelete;
        } else {
            throw new NoSuchElementException("Product not found with id: " + id);
        }
    }

    @Override
    public Product getProductById(long id) {
        Product product = repo.findById(id).orElse(null);
        if (product != null) {
            return product;
        } else {
            throw new NoSuchElementException("Product not found with id: " + id);
        }
    }
}
