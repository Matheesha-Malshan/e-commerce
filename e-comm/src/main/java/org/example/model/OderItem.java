package org.example.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.entity.OrderEntity;
import org.example.entity.ProductVariantEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OderItem {

    private Integer id;
    private Integer quantity;
    private String price;
    private ProductVariantEntity product_Variant;

}


