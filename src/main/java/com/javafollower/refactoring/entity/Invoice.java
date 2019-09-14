package com.javafollower.refactoring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Invoice {
    private String customer;
    private List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }
}
