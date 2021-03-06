package com.javafollower.refactoring.statement.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Performance {
    private String playID;
    private int audience;
    private Play play;
    private int amount;
    private int volumeCredits;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
}
