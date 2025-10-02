package org.example.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerBill {


    private Integer customerId;
    private String email;
    private String phoneNumber;
    private Double totalPrice;

    private List<BillDetails> bill=new ArrayList<>();

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
