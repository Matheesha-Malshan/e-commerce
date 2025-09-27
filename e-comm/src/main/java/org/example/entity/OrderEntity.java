package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Customer;
import org.example.model.OrderItem;

import java.sql.Timestamp;
import java.util.List;
/*
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")*/
public class OrderEntity {
/*
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;
    private Timestamp dataTime;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItemEntity> orderItemList;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    */

}
