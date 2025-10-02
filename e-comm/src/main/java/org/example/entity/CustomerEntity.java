package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.ProductReview;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private Timestamp dataTime;


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("customerCart")
    private ShoppingCartEntity shoppingCart;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("customerOrder")
    private List<OrderEntity> orderEntity=new ArrayList<>();

    @OneToMany(mappedBy = "customerReview",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("customerReview")
    private List<ProductReviewEntity> reviews=new ArrayList<>();

    @OneToMany(mappedBy = "customerNotification",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("NotificationJson")
    private List<NotificationEntity> notificationyList=new ArrayList<>();
}
