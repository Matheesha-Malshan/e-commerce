package org.example.service;

import org.example.entity.CartItemEntity;
import org.example.model.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    void  updateCustomerCart(Integer customer_id, CartItemEntity cartItemEntity);
}
