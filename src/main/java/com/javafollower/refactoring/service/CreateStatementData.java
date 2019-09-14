package com.javafollower.refactoring.service;

import com.javafollower.refactoring.entity.*;
import com.javafollower.refactoring.performance.ComedyCalculator;
import com.javafollower.refactoring.performance.TragedyCalculator;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.lang.reflect.Method;

public class CreateStatementData {

    private Statement statement;

    public Statement statement(Invoice invoice, Plays plays) {
        statement = new Statement(invoice.getCustomer(), invoice.getPerformances(), plays);
        statement.getPerformances().forEach(this::renderPlainText);
        statement.setAmount(usd(totalAmount()));
        statement.setVolumeCredits(totalVolumeCredits());
        return statement;
    }

    private void renderPlainText(Performance performance) {
        performance.setPlay(getPlay(performance.getPlayID()));
        performance.setAmount(usd(amountFor(performance)));
    }

    private int totalAmount() {
        return statement.getPerformances().stream().mapToInt(this::amountFor).sum();
    }

    private int totalVolumeCredits() {
        return statement.getPerformances().stream().mapToInt(this::volumeCreditsFor).sum();
    }

    private int volumeCreditsFor(Performance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);
        if ("comedy".equals(getPlay(performance.getPlayID()).getType())) {
            result += Math.floor(performance.getAudience() / 5);
        }
        return result;
    }

    private int amountFor(Performance performance) {
        switch (performance.getPlay().getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, performance.getPlay()).amount();
            case "comedy":
                return new ComedyCalculator(performance, performance.getPlay()).amount();
            default:
                throw new Error("unknown type " + performance.getPlay().getType());
        }
    }

    private String usd(int amount) {
        return Money.of(CurrencyUnit.USD, amount / 100).toString();
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
