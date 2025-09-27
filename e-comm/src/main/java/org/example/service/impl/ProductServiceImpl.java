package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.ProductEntity;
import org.example.entity.ProductVariantEntity;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;
    final ModelMapper mapper;

    public Product createProduct(Product product){

        ProductEntity productEntity=new ProductEntity(
                product.getId(),
                product.getTitle(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getImage(),
                product.getCreatedBy(),
                product.getCreatedDate(),
                product.getModifiedBy()
        );


       if(product.getProductSizes()!=null){
           for(ProductVariantEntity productVariant:product.getProductSizes()){
               ProductVariantEntity productVariantEntity=new ProductVariantEntity(
                       productVariant.getSize(),
                       productVariant.getStock(),
                       productVariant.getSku()
               );
               productVariantEntity.setProductEntity(productEntity);
               productEntity.getProductSizes().add(productVariantEntity);
           }
       }
        ProductEntity pv=productRepository.save(productEntity);

        return mapper.map(pv,Product.class);
    
    }

    @Override
    @Transactional
    public Product updateProduct(Integer id,Product product) {

        Optional<ProductEntity> productEntity=productRepository.findById(id);

        ProductEntity p=productEntity.get();
        productEntity.get().setTitle(product.getTitle());
        productEntity.get().setPrice(product.getPrice());
        productEntity.get().setDescription(product.getDescription());
        productEntity.get().setCategory(product.getCategory());
        productEntity.get().setImage(product.getImage());
        productEntity.get().setCreatedBy(product.getCreatedBy());
        productEntity.get().setCreatedDate(product.getCreatedDate());
        productEntity.get().setModifiedBy(product.getModifiedBy());

        List<ProductVariantEntity> productVariantEntities=product.getProductSizes();
        List<ProductVariantEntity> existProductVariant=productEntity.get().getProductSizes();

        for(ProductVariantEntity productVariant:productVariantEntities){

            for(ProductVariantEntity existVariant:existProductVariant){

                if(existVariant.getId().equals(productVariant.getId())){
                    if(!existVariant.getStock().equals(productVariant.getStock())){
                        existVariant.setStock(productVariant.getStock());
                    }
                }
            }

        }
        return null;
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
