package com.javafollower.refactoring.statement.performance;

import com.javafollower.refactoring.statement.entity.Performance;
import com.javafollower.refactoring.statement.entity.Play;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ComedyCalculator extends PerformanceCalculator {

    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    public int amount() {
        int audience = getPerformance().getAudience();

        int result = 30000;
        if (audience > 20) {
            result += 10000 + 500 * (audience - 20);
        }
        result += 300 * audience;

        return result;
    }

    public int volumeCredits() {
        return (int) (super.volumeCredits() + Math.floor(getPerformance().getAudience() / 5));
    }

}
