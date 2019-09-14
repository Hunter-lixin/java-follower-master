package com.javafollower.refactoring.statement.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Statement {

    private String customer;
    private List<Performance> performances;
    private Plays plays;
    private int amount ;
    private int volumeCredits;

    public Statement(String customer, List<Performance> performances, Plays plays) {
        this.customer = customer;
        this.performances = performances;
        this.plays = plays;
    }

}
