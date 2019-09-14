package com.javafollower.designpattern.strategypattern.saleService;
/**
 * 策略模式
 */


import com.javafollower.designpattern.strategypattern.saleService.interfaceService.DisCount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {

    Map<String, DisCount> disCountMap = new HashMap<>();

    public SaleService(List<DisCount> disCounts) {
        for (DisCount disCount : disCounts) {
            disCountMap.put(disCount.type(), disCount);
        }
    }

    public double getDisCount(String type, double fee) {
        return disCountMap.get(type).salePrice(fee);
    }

}
