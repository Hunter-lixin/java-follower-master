package com.javafollower.designpattern.observerpattern.orderService.listener;

import com.javafollower.designpattern.observerpattern.orderService.event.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PhListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("发送Ph消息");
    }
}
