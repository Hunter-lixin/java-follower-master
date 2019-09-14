package com.javafollower.designpattern.observerpattern.orderService;
/**
 * 观察者模式
 */

import com.javafollower.designpattern.observerpattern.orderService.event.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    ApplicationContext applicationContext;
    
    public void saveOrder() {
        System.out.println("订单保存成功！");

        Map<String, Object> map = new HashMap<>();
        map.put("userName", "linda");

        applicationContext.publishEvent(new OrderEvent(map));
    }

}
