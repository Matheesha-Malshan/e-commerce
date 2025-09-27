package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.model.ProductVariant;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "proc")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
    private String createdBy;
    private Timestamp createdDate;
    private String modifiedBy;

    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("product-variants")
    private List<ProductVariantEntity> productSizes=new ArrayList<>();

    public ProductEntity(Integer id, String title, String price, String description,
                         String category, String image, String createdBy, Timestamp createdDate, String modifiedBy){
        this.id=id;
        this.title=title;
        this.price=price;
        this.description=description;
        this.category=category;
        this.image=image;
        this.createdBy=createdBy;
        this.createdDate=createdDate;
        this.modifiedBy=modifiedBy;
    }

}
