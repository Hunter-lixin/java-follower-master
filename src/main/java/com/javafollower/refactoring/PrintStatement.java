package com.javafollower.refactoring;

import com.javafollower.refactoring.entity.*;
import com.javafollower.refactoring.service.CreateStatementData;

import java.util.ArrayList;
import java.util.List;

public class PrintStatement {

    private static List<Invoice> invoices() {
        List<Performance> performances = new ArrayList<>();
        performances.add(new Performance("hamlet", 55));
        performances.add(new Performance("asLike", 35));
        performances.add(new Performance("othello", 40));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice("BigCo", performances));

        return invoices;
    }

    private static Plays plays() {
        return new Plays(
                new Play("Hamlet", "tragedy"),
                new Play("As You Like It", "comedy"),
                new Play("Othello", "tragedy")
        );
    }

    private static void renderPlainText(Statement statement) {
        System.out.println("Statement for " + statement.getCustomer());
        for (Performance performance : statement.getPerformances()) {
            System.out.println("    " + performance.getPlay().getName() + ": "
                    + performance.getAmount() + " (" + performance.getAudience() + " seats)");
        }
        System.out.println("Amount owed is " + statement.getAmount());
        System.out.println("You earned " + statement.getVolumeCredits() + " credits");
    }

    public static void main(String[] args) {
        List<Invoice> invoices = invoices();
        Plays plays = plays();

        CreateStatementData createStatementData = new CreateStatementData();
        for (Invoice invoice : invoices) {
            Statement statement = createStatementData.statement(invoice, plays);
            renderPlainText(statement);
        }


    }
}
