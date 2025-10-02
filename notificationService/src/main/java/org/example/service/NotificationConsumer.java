package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.CustomerBill;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {

    final  EmailService emailService;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group-v2")
    public void consumeNotification(CustomerBill bill) {

        String text="";
        String textItems="";
        text+="customer id"+bill.getCustomerId()+"total price"+bill.getTotalPrice();

        for(CustomerBill.BillDetails details:bill.getBill()){

            textItems+="product-variant id"+details.getProductVariantId();
            textItems+="description"+details.getDescription();
            textItems+=details.getSize();
            textItems+="cloth size";
            textItems+="cloth sku"+details.getSku();
            textItems+="quantity"+details.getQuantity();
            textItems+="item price"+details.getPrice();


        }
        text+=textItems;

        emailService.sendOrderConfirmation(bill.getEmail(), text);

    }
}
