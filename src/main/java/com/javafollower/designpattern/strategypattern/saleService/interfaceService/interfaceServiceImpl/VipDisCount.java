package com.javafollower.designpattern.strategypattern.saleService.interfaceService.interfaceServiceImpl;

import com.javafollower.designpattern.strategypattern.saleService.interfaceService.DisCount;
import org.springframework.stereotype.Component;

@Component
public class VipDisCount implements DisCount {
    @Override
    public String type() {
        return "vip";
    }

    @Override
    public double salePrice(double fee) {
        return fee * 0.9;
    }


}
