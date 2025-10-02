package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.example.entity.OrderEntity;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private Timestamp dataTime;

    @JsonIgnore
    private List<OrderEntity> orderEntity;
}
