package org.example.service;


public interface NotificationSubject<T> {
    void registerObservers(NotificationObserver<T> notificationObserver);
    void notifyObservers(T orderCreate);
}
