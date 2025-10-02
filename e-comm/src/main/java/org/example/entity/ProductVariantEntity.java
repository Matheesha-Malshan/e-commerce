package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @JsonBackReference("productVariantJson")
    private ProductEntity productEntity;

    @OneToMany(mappedBy = "product_Variant",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cartItemJson")
    private List<OrderItemEntity> orderItemEntity=new ArrayList<>();

    @OneToMany(mappedBy = "cartItem_variant",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("cartItemJson")
    private List<CartItemEntity> cartItemEntityList=new ArrayList<>();

    public ProductVariantEntity(String size,Integer stock,String sku){

        this.size=size;
        this.stock=stock;
        this.sku=sku;
    }
    public ProductVariantEntity(Integer id){
        this.id=id;
    }

}
