package com.javafollower.designpattern.strategypattern.saleService.interfaceService;

public interface DisCount {
    String type();

    double salePrice(double fee);
}
