package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@ToString
public class ProductReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer product_Variant_id;

    private Timestamp created_at;
    private Timestamp updated_at;
    private String status;
    private String text;
    private String content;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference("customerReview")
    private CustomerEntity customerReview;
}
