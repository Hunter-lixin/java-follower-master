package com.javafollower.refactoring.statement.performance;

import com.javafollower.refactoring.statement.entity.Performance;
import com.javafollower.refactoring.statement.entity.Play;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TragedyCalculator extends PerformanceCalculator {

    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    public int amount() {
        int result = 40000;
        if (getPerformance().getAudience() > 30) {
            result += 1000 * (getPerformance().getAudience() - 30);
        }
        return result;
    }

}
