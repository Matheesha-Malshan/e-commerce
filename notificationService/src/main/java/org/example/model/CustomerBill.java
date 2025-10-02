package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CustomerBill {
    private Integer customerId;
    private String email;
    private String phoneNumber;
    private Double totalPrice;

    private List<BillDetails> bill;

    @Getter
    @Setter
    public static class BillDetails{
        private Integer productVariantId;
        private Double price;
        private Integer quantity;
        private String size;
        private String sku;
        private String description;

    }
}
