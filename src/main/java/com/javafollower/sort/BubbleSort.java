package com.javafollower.sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(Integer[] a) {
        int n = a.length;

        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }

            if (!flag) break;

        }
    }


}
