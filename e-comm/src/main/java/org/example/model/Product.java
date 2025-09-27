package org.example.model;

import lombok.*;
import org.example.entity.ProductVariantEntity;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
    private String createdBy;
    private Timestamp createdDate;
    private String modifiedBy;
    private List<ProductVariantEntity> productSizes;
}
