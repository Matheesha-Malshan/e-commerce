package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItem {

    private Integer id;
    private String productId;
    private Integer quantity;


}
