package com.javafollower.refactoring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Plays {
    private Play hamlet;
    private Play asLike;
    private Play othello;

    public Plays(Play hamlet, Play asLike, Play othello) {
        this.hamlet = hamlet;
        this.asLike = asLike;
        this.othello = othello;
    }
}
