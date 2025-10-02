package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.example.entity.CustomerEntity;
import org.example.entity.OrderItemEntity;
import org.example.entity.ProductVariantEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private Integer id;
    private Timestamp dataTime;
    private String price;
    private List<OrderItemEntity> orderItemList;


}
