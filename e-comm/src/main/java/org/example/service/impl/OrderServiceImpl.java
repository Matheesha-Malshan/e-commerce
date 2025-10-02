package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.CustomerEntity;
import org.example.entity.OrderEntity;
import org.example.entity.OrderItemEntity;
import org.example.entity.ProductVariantEntity;
import org.example.model.CustomerBill;
import org.example.model.Order;
import org.example.repository.CutomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductVariantRepository;
import org.example.service.NotificationObserver;
import org.example.service.NotificationSubject;
import org.example.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService, NotificationSubject<CustomerBill> {

    final OrderRepository orderRepository;
    final CutomerRepository cutomerRepository;
    final ModelMapper mapper;
    final ProductVariantRepository productVariantRepository;


    List<NotificationObserver<CustomerBill>> observers=new ArrayList<>();

    @Override
    @Transactional
    public Order createOrder(Integer customerId,Order order) {

        CustomerBill customerBill=new CustomerBill();

        Optional<CustomerEntity> customerList= cutomerRepository.findById(customerId);

        CustomerEntity customer=customerList.get();

        customerBill.setCustomerId(customerId);
        customerBill.setEmail(customerList.get().getEmail());
        customerBill.setPhoneNumber(customerList.get().getPhoneNumber());

        OrderEntity orderEntity=new OrderEntity(
                order.getDataTime()
        );

        orderEntity.setOrder(customer);
        customer.getOrderEntity().add(orderEntity);

        List<OrderItemEntity> orderItemEntityList=order.getOrderItemList();

        Double totalPrice=0.0;

        for(OrderItemEntity items:orderItemEntityList){
            totalPrice+=items.getPrice();

            CustomerBill.BillDetails details=new CustomerBill.BillDetails();
            ProductVariantEntity productVariantEntity=items.getProduct_Variant();

            Optional<ProductVariantEntity> products=productVariantRepository.findById(productVariantEntity.getId());


            details.setProductVariantId(productVariantEntity.getId());

            details.setSku(products.get().getSku());
            details.setSize(products.get().getSize());
            details.setPrice(items.getPrice());
            details.setQuantity(items.getQuantity());

            products.get().setStock(products.get().getStock()- items.getQuantity());

            OrderItemEntity orderItem=new OrderItemEntity(
                    items.getQuantity(),
                    items.getPrice()
            );


            customerBill.getBill().add(details);

            orderItem.setProduct_Variant(items.getProduct_Variant());
            orderItem.setOrderEntity(orderEntity);
            orderEntity.getOrderItemList().add(orderItem);

        }

         orderEntity.setTotalPrice(totalPrice);
         customerBill.setTotalPrice(totalPrice);
         OrderEntity orderCreate=orderRepository.save(orderEntity);

         Order savedOrder=mapper.map(orderCreate,Order.class);

         notifyObservers(customerBill);

         return savedOrder;
    }

    @Override
    public void updateProductTable() {

    }

    @Override
    public void registerObservers(NotificationObserver<CustomerBill> notificationObserver) {
        observers.add(notificationObserver);
    }

    @Override
    public void notifyObservers(CustomerBill orderCreate) {

        for (NotificationObserver<CustomerBill> notificationObserver:observers){
            notificationObserver.sendNotification(orderCreate);
        }
    }
}
