package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.CartItemEntity;
import org.example.model.ShoppingCart;
import org.example.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class ShoppingCartController {

    final ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ShoppingCart createCart(@RequestBody ShoppingCart shoppingCart){
      return shoppingCartService.createShoppingCart(shoppingCart);

    }



}
