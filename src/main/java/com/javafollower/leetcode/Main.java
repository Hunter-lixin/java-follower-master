package com.javafollower.leetcode;

import java.util.*;

public class Main {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            String[] array = input.split("");

            TreeSet<String> keyTreeSet = new TreeSet<>(Arrays.asList(array));

            Map<String, Integer> resultMap = new HashMap<>();
            for (String key : keyTreeSet) {
                resultMap.put(key, 0);
            }

            for (String key : array) {
                int value = resultMap.get(key);
                value++;
                resultMap.put(key, value);
            }

            TreeSet<Integer> valueTreeSet = new TreeSet<>();
            for (String key : resultMap.keySet()) {
                valueTreeSet.add(resultMap.get(key));
            }

            StringBuilder result = new StringBuilder();
            List<Integer> valueList = new ArrayList<>(valueTreeSet);
            for (int i = valueList.size() - 1; i >= 0; i--) {
                for (String key : keyTreeSet) {
                    if (resultMap.get(key).equals(valueList.get(i))) {
                        result.append(key).append(":").append(resultMap.get(key)).append(";");
                    }
                }
            }

            System.out.println(result.toString());
        }
    }
}
