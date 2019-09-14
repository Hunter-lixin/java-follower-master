package com.javafollower.designpattern.strategypattern.saleService.interfaceService.interfaceServiceImpl;

import com.javafollower.designpattern.strategypattern.saleService.interfaceService.DisCount;
import org.springframework.stereotype.Component;

@Component
public class SvipDisCount implements DisCount {
    @Override
    public String type() {
        return "svip";
    }

    @Override
    public double salePrice(double fee) {
        return fee * 0.5;
    }

}
