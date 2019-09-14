package com.javafollower.demo;

import com.javafollower.designpattern.observerpattern.orderService.OrderService;
import com.javafollower.designpattern.strategypattern.saleService.SaleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    OrderService orderService;

    @Autowired
    SaleService saleService;

    @Test
    public void contextLoads() {
        orderService.saveOrder();
//        double disCount = saleService.getDisCount("svip", 100);
//        System.out.println("消费费用：" + disCount);
    }


}
