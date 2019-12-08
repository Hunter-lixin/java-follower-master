package com.javafollower.leetcode;

import java.util.Scanner;

public class EmptyBotty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int initCount = scan.nextInt();
            if (initCount == 0) {
                break;
            }

            int resultCount = 0;
            while (initCount >= 3) {
                int tempCount = initCount / 3;
                resultCount += tempCount;
                initCount = initCount % 3 + tempCount;
                if (initCount == 2) {
                    initCount++;
                }
            }

            System.out.println(resultCount);
        }
    }
}