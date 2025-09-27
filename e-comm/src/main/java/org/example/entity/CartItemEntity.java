package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    private String productId;

    @ManyToOne
    @JoinColumn(name ="cart_id")
    @JsonBackReference("cart-items")
    private ShoppingCartEntity shoppingCart;


    public CartItemEntity(String productId, Integer quantity) {
        this.quantity=quantity;
        this.productId=productId;
    }
}
