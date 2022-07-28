package com.example.mysqlcrud.service;

import com.example.mysqlcrud.entity.Product;
import com.example.mysqlcrud.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public Product savedProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repo.saveAll(products);
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repo.findByName(name);
    }

    public String deleteProduct(int id) {
        repo.deleteById(id);

        return "product removed !! " + id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repo.findById(product.getId()).orElse(null);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return  repo.save(existingProduct);
    }
}

