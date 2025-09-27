package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class ProductVariant {
    private Integer id;
    private String size;
    private Integer stock;
    private String sku;
}
