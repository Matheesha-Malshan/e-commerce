package org.example.model;

import lombok.*;
import org.example.entity.CustomerEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCart {

    private Integer id;
    private Customer customer;
    private List<CartItem> cartItemsList;
}
