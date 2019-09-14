package com.javafollower.refactoring.statement.service;

import com.javafollower.refactoring.statement.entity.*;
import com.javafollower.refactoring.statement.performance.ComedyCalculator;
import com.javafollower.refactoring.statement.performance.PerformanceCalculator;
import com.javafollower.refactoring.statement.performance.TragedyCalculator;

import java.lang.reflect.Method;

public class CreateStatementData {

    private Statement statement;

    public Statement statement(Invoice invoice, Plays plays) {
        statement = new Statement(invoice.getCustomer(), invoice.getPerformances(), plays);
        statement.getPerformances().forEach(this::renderPlainText);
        statement.setAmount(totalAmount());
        statement.setVolumeCredits(totalVolumeCredits());
        return statement;
    }

    private void renderPlainText(Performance performance) {
        performance.setPlay(getPlay(performance.getPlayID()));
        PerformanceCalculator performanceCalculator = createPerformanceCalculator(performance);
        performance.setAmount(performanceCalculator.amount());
        performance.setVolumeCredits(performanceCalculator.volumeCredits());
    }

    private int totalAmount() {
        return statement.getPerformances().stream().mapToInt(Performance::getAmount).sum();
    }

    private int totalVolumeCredits() {
        return statement.getPerformances().stream().mapToInt(Performance::getVolumeCredits).sum();
    }

    private PerformanceCalculator createPerformanceCalculator(Performance performance) {
        switch (performance.getPlay().getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, performance.getPlay());
            case "comedy":
                return new ComedyCalculator(performance, performance.getPlay());
            default:
                throw new Error("unknown type " + performance.getPlay().getType());
        }
    }

    private Play getPlay(String playID) {
        String methodStr = "get" + playID.substring(0, 1).toUpperCase() + playID.substring(1);
        Method method;
        Play play = null;
        try {
            method = statement.getPlays().getClass().getDeclaredMethod(methodStr, null);
            play = (Play) method.invoke(statement.getPlays(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return play;
    }
}
