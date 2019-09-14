package com.javafollower.redblue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.javafollower.sort.BubbleSort.sort;

public class RedBlueRandom {

    private static void getRedBlueRandom() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 33 + 1);
            if (!integers.contains(a)) {
                integers.add(a);
            }
            if (integers.size() == 6) {
                break;
            }
        }

        Integer[] integerArray = new Integer[integers.size()];
        integers.toArray(integerArray);
        sort(integerArray);

        integers = new ArrayList<>();
        Collections.addAll(integers, integerArray);

        StringBuffer stringBufferRed = new StringBuffer(" ");
        for (Integer integer : integers) {
            String interStr = String.valueOf(integer);
            if (integer < 10) {
                interStr = "0" + interStr;
            }

            stringBufferRed.append(interStr).append("  ");
        }

        int blueInt = (int) (Math.random() * 16 + 1);
        String blueStr = String.valueOf(blueInt);
        if (blueInt < 10) {
            blueStr = "0" + blueStr;
        }

        stringBufferRed.append("+ ").append(blueStr);
        System.out.println(stringBufferRed.toString());
    }

    public static void main(String[] args) {
        System.out.println("计算日期：" + LocalDateTime.now());
        for (int i = 0; i < 5; i++) {
            getRedBlueRandom();
        }
    }
}
