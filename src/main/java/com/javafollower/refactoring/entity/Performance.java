package com.javafollower.refactoring.entity;

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
    private String amount;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
}
