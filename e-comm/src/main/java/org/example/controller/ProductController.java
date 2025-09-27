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
        return productService.updateProduct(product.getId(),product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Integer id,
                              @RequestParam String deleteby){

        boolean deleted=productService.deleteProduct(id,deleteby);
        return deleted;
    }
    
}
