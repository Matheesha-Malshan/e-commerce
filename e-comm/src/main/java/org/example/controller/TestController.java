package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    /*
    private NotificationProducer notificationProducer;

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationEvent event) {
        //System.out.println(event.getUserId());
        //notificationProducer.sendNotification(event);
        //return "Message sent to Kafka!";
    }

     */
}
