package org.example.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.entity.OrderEntity;
import org.example.model.CustomerBill;
import org.example.model.Notification;
import org.example.model.NotificationEvent;
import org.example.model.Order;
import org.example.service.NotificationObserver;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationObserver<CustomerBill> {


    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "notification-topic";
    @Lazy
    final OrderServiceImpl orderService;

    @PostConstruct
    public void init(){
        orderService.registerObservers(this);
    }
    @Override
    public void sendNotification(CustomerBill message) {
        System.out.println("order send to micro"+message);
        kafkaTemplate.send(TOPIC, message);
    }

}
