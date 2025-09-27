package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String size;
    private Integer stock;
    private String sku;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonBackReference("product-variants")
    private ProductEntity productEntity;

    public ProductVariantEntity(String size,Integer stock,String sku){

        this.size=size;
        this.stock=stock;
        this.sku=sku;
    }

}
