package com.ktotopawel.aoc2025.day2;

import com.ktotopawel.aoc2025.Utils;

public class GiftShop {
    public static void main(String[] args) {
        String input = Utils.readString("day2.txt");
        System.out.println(countErrorsInInput(input));
    }

    public static long countErrorsInInput(String input) {
        return Range.fromInput(input).stream().reduce(0L, (sum, range) -> sum + countErrorsInRange(range), Long::sum);
    }

    private static long countErrorsInRange(Range range) {
        long count = 0;
        for (long i = range.start(); i <= range.end(); i++) {
            boolean isRepeated = true;
            String iString = i + "";
            int len = iString.length();
            // can't have two repetitions if not even
            if (len % 2 != 0) continue;

            //two pointer approach
            for (int j = 0, middle = len / 2; j < len / 2; j++, middle++) {
                if (iString.charAt(j) != iString.charAt(middle)) {
                    isRepeated = false;
                    break;
                }
            }
            if (isRepeated) {
                count += i;
            }
        }
        return count;
    }
}
