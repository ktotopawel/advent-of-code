package com.ktotopawel.aoc2025.day3;

import com.ktotopawel.aoc2025.Utils;

import java.util.List;

public class Lobby2 {
    private final static int REQ_BATTERIES = 12;

    public static void main(String[] args) {
        List<String> input = Utils.readLines("day3.txt");

        System.out.println(countJoltageFromInput(input));
    }

    public static long countJoltageFromInput(List<String> input) {
        return input.stream().reduce(0L, (sum, cur) -> sum + countJoltageInBank(cur), Long::sum);
    }

    private static long countJoltageInBank(String bank) {
        StringBuilder joltageString = new StringBuilder();

        int lastI = 0;

        for (int i = 0; i < REQ_BATTERIES; i++) {
            int toI = Math.min(bank.length() - REQ_BATTERIES + i, bank.length() - 1);

            System.out.println("fromI " + lastI + " toI " + toI);

            int max = 0;

            for (int j = lastI; j <= toI; j++) {
                int curValue =Integer.parseInt(String.valueOf(bank.charAt(j)));
                if (max < curValue) {
                    lastI = j;
                    max = curValue;
                }
            }
            joltageString.append(max);
            lastI++;
        }

        System.out.println("Joltage for bank " + bank + ": " + joltageString);

        return Long.parseLong(joltageString.toString());
    }
}
