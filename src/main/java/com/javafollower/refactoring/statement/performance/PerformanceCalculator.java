package com.javafollower.refactoring.statement.performance;

import com.javafollower.refactoring.statement.entity.Performance;
import com.javafollower.refactoring.statement.entity.Play;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PerformanceCalculator {

    private Performance performance;
    private Play play;

    PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public int amount() {
        throw new Error("subClass responsibility");
    }

    public int volumeCredits() {
        return Math.max(performance.getAudience() - 30, 0);
    }

}
