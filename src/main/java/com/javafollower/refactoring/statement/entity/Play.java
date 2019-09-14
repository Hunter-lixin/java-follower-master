package com.javafollower.refactoring.statement.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Play {
    private String name;
    private String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
