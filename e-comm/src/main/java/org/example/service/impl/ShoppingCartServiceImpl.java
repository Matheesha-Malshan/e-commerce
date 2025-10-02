package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.CartItemEntity;
import org.example.entity.CustomerEntity;
import org.example.entity.ShoppingCartEntity;
import org.example.model.CartItem;
import org.example.model.Customer;
import org.example.model.ShoppingCart;
import org.example.repository.CutomerRepository;
import org.example.repository.ShoppingCartRepository;
import org.example.service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    final ShoppingCartRepository shoppingCartRepository;
    final CutomerRepository cutomerRepository;
    final ModelMapper mapper;

    @Transactional
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart){

        List<CartItem> cartItem=shoppingCart.getCartItemsList();
        ShoppingCartEntity shoppingCartEntity=new ShoppingCartEntity();

        for(CartItem cart:cartItem){
            CartItemEntity cartItemEntity=new CartItemEntity(
                    cart.getProductId(),
                    cart.getQuantity()
            );
            cartItemEntity.setShoppingCart(shoppingCartEntity);
            shoppingCartEntity.getCartItemsList().add(cartItemEntity);
        }

        ShoppingCartEntity s=shoppingCartRepository.save(shoppingCartEntity);

        return mapper.map(s,ShoppingCart.class);
    }

}
