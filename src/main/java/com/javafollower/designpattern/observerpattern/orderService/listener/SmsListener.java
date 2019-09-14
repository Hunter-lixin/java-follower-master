package com.javafollower.designpattern.observerpattern.orderService.listener;

import com.javafollower.designpattern.observerpattern.orderService.event.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
public class SmsListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("发送短信消息");
        System.out.println(orderEvent.getSource());
        Object object = orderEvent.getSource();
//        System.out.println((Map<String, Object>) object);
        String username = (String) ((Map<String, Object>) object).get("userName");
        System.out.println(username);
//        Map<String, Object> map = obj2Map(object);
//        System.out.println(map);
//        System.out.println(map.get("username"));

    }


    private static Map<String, Object> obj2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields(); // 获取对象对应类中的所有属性域
        for (int i = 0; i < fields.length; i++) {
            String varName = fields[i].getName();
            varName = varName.toUpperCase();///将key置为大写，默认为对象的属性
            boolean accessFlag = fields[i].isAccessible(); // 获取原来的访问控制权限
            fields[i].setAccessible(true);// 修改访问控制权限
            try {
                Object object = fields[i].get(obj); // 获取在对象中属性fields[i]对应的对象中的变量
                if (object != null) {
                    map.put(varName, object);
                } else {
                    map.put(varName, null);
                }
                fields[i].setAccessible(accessFlag);// 恢复访问控制权限
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
