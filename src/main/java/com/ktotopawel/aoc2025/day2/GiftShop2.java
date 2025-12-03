package com.ktotopawel.aoc2025.day2;

import com.ktotopawel.aoc2025.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GiftShop2 {
    public static void main(String[] args) {
        long ans = 0;

        String input = Utils.readString("day2.txt");
        List<Range> parsedRecords = Range.fromInput(input);

        for (Range record : parsedRecords) {
            for (long i = record.start(); i <= record.end(); i++) {
                String parsedString = String.valueOf(i);

                if ((parsedString + parsedString).indexOf(parsedString, 1) != parsedString.length()) {
                    ans += i;
                }
            }
        }

        System.out.println(ans);
    }
}
