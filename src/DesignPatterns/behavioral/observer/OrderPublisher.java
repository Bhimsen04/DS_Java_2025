package DesignPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderPublisher {

    private List<IOrderObserver> observers = new ArrayList<>();

    public void subscribe(IOrderObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(IOrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String orderId) {
        for (IOrderObserver obs : observers) {
            obs.update(orderId);
        }
    }
}

