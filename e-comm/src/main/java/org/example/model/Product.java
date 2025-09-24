package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
public class Product {

    private Integer id;
    private String title;
    private String price;
    private String description;
    private String category;
    private String image;
    private String createdBy;
    private Timestamp createdDate;
    private String modifiedBy;
}
