package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.CartItemEntity;
import org.example.model.Customer;
import org.example.repository.CutomerRepository;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);

    }
    @PostMapping("/{customer_id}")
    public void updateCart(@PathVariable Integer customer_id,
                           @RequestBody CartItemEntity cartItemEntity){

        customerService.updateCustomerCart(customer_id,cartItemEntity);

    }

}
