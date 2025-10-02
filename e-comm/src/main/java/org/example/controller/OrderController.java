package org.example.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;

    @PostMapping("/order/{customerId}/")
    public Order createOrder(@PathVariable Integer customerId, @RequestBody Order order){
        return orderService.createOrder(customerId,order);
    }


}
