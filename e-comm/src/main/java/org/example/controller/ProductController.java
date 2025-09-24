package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/delete/{id}/{userType}")
    public Product deleteProduct(@PathVariable String id, String userType){
        return deleteProduct(id,userType);
    }
}
