package com.ktotopawel.aoc2025.day5;

import com.ktotopawel.aoc2025.Utils;

import java.util.Collections;
import java.util.Comparator;

public class Cafeteria2 {
    public static void main(String[] args) {
        IngredientsList input = Utils.readIngredientsList("day5.txt");
//        System.out.println(input);
        System.out.println(countFresh(input));
    }

    public static long countFresh(IngredientsList ingredientsList) {
        long count = 0;

        ingredientsList.freshRange().sort(Comparator.comparingLong(IdRange::start));

        long nextValidId = Long.MIN_VALUE;

        for (IdRange range : ingredientsList.freshRange()) {
            long from = range.start(), to = range.end();
            if (to < nextValidId) continue;
            if (from < nextValidId) {
                from = nextValidId;
            }
            nextValidId = to + 1;

            long added = (to - from) + 1;
            System.out.println("for range: " + range.start() + ", " + range.end() + " added: " + added);
            count += added;
            System.out.println("for range: " + range.start() + ", " + range.end() + " count: " + count);
        }

        return count;
    }
}
