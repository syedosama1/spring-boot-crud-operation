package com.technic.crud.operations.service;

import com.technic.crud.operations.entity.Product;
import com.technic.crud.operations.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);

    }
    public List<Product> saveProducts(List<Product> products){
        return  productRepository.saveAll(products);
    }
    public List<Product>  getProducts(){
        return productRepository.findAll();

    }
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
    public  Product getProductByName(String name){
        return productRepository.findByName(name);
    }
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted successfully with ID: " + id;
    }
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

}
