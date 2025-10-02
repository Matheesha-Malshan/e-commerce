package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp dataTime;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("OrderItems")
    private List<OrderItemEntity> orderItemList=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference("customerOrder")
    private CustomerEntity order;

    private Double totalPrice;

    public OrderEntity(Timestamp dataTime){
        this.dataTime=dataTime;
    }
}
