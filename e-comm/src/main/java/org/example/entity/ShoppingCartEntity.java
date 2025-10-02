package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference("customerCart")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "shoppingCart",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cartItems")
    private List<CartItemEntity> cartItemsList=new ArrayList<>();;

}
