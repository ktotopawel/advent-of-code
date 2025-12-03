package com.ktotopawel.aoc2025.day3;

import com.ktotopawel.aoc2025.Utils;

import java.util.List;

public class Lobby {
    public static void main(String[] args) {
        List<String> input = Utils.readLines("day3.txt");
        System.out.println(getJoltageFromInput(input));
    }

    public static long getJoltageFromInput(List<String> input) {
        long joltage = 0;

        for (String line : input) {
            long curJ = getJoltage(line);
            joltage += curJ;
        }

        return joltage;
    }

    private static long getJoltage(String batteries) {
        int tens = 0;
        int ones = 0;

        for (int i = 0; i < batteries.length(); i++) {
            int cur = Integer.parseInt(String.valueOf(batteries.charAt(i)));
            if (cur > tens && i != batteries.length() - 1) {
                tens = cur;
                ones = Integer.parseInt(String.valueOf(batteries.charAt(i + 1 )));
            } else if (cur > ones) {
                ones = cur;
            }
        }

        long ans = tens * 10L + ones;

        System.out.println("Current bank: " + batteries + " | Joltage = " + ans);

        return ans;
    }

}
