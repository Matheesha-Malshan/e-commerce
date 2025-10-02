package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.model.Order;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference("OrderItems")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "product_variant_id")
    @JsonBackReference("cartItemJson")
    private ProductVariantEntity product_Variant;

    public OrderItemEntity(Integer quantity,Double price){
        this.quantity=quantity;
        this.price=price;
    }
}
