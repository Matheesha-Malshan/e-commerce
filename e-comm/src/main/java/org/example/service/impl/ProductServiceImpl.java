package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.ProductEntity;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;
    final ModelMapper mapper;

    public Product createProduct(Product product){

        ProductEntity productEntity=productRepository.save(mapper.map(product,
                ProductEntity.class));
        return mapper.map(productEntity,Product.class);
    }

    @Override
    public Product updateProduct(Product product) {
        ProductEntity productEntity=productRepository.save(mapper.map(product,
                ProductEntity.class));
        return mapper.map(productEntity,Product.class);
    }

    @Transactional
    public boolean deleteProduct(Integer id, String deleteby){

        Optional<ProductEntity> productOpt = productRepository.findById(id);

        ProductEntity product=productOpt.get();
        product.setModifiedBy(deleteby);

        productRepository.save(product);
        productRepository.deleteById(id);

        return false;
    }

}
