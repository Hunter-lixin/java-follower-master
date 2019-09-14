package com.javafollower.designpattern.observerpattern.orderService.event;

import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {
    public OrderEvent(Object source) {
        super(source);
    }
}
