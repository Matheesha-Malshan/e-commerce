package org.example.service;

import org.example.model.Product;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);
}
