package org.example.service;

import org.example.entity.OrderEntity;

public interface NotificationObserver<T>{

    void sendNotification(T message);
}
