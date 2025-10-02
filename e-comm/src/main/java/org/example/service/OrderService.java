package org.example.service;

import org.example.model.Order;

public interface OrderService {

    Order createOrder(Integer customerId,Order order);

    void updateProductTable();
}
