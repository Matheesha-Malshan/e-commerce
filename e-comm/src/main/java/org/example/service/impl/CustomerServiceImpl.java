package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.entity.CartItemEntity;
import org.example.entity.CustomerEntity;
import org.example.entity.ShoppingCartEntity;
import org.example.model.Customer;
import org.example.repository.CartItemRepository;
import org.example.repository.CutomerRepository;
import org.example.repository.ShoppingCartRepository;
import org.example.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CartItemRepository cartItemRepository;
    final CutomerRepository cutomerRepository;
    final ShoppingCartRepository shoppingCartRepository;
    final ModelMapper mapper;

    public Customer createCustomer(Customer customer){
        CustomerEntity customerEntity=cutomerRepository.save(mapper.map(customer,CustomerEntity.class));


       return mapper.map(customerEntity,Customer.class);

    }
    @Transactional
    public void  updateCustomerCart(Integer customer_id,
                                    CartItemEntity cartItemEntity){

        Optional<CustomerEntity> customer=cutomerRepository.findById(customer_id);

        ShoppingCartEntity shoppingCart=customer.get().getShoppingCart();
        if(shoppingCart==null){
            shoppingCart=new ShoppingCartEntity();

            shoppingCart.setCustomer(customer.get());
            customer.get().setShoppingCart(shoppingCart);
            shoppingCart=shoppingCartRepository.save(shoppingCart);
        }


        CartItemEntity cartItem=new CartItemEntity();

        cartItem.setProductId(cartItemEntity.getProductId());
        cartItem.setQuantity(cartItemEntity.getQuantity());


        cartItem.setShoppingCart(shoppingCart.getCustomer().getShoppingCart());

        CartItemEntity cartSave=cartItemRepository.save(cartItem);

        shoppingCart.getCartItemsList().add(cartSave);

    }
}
