package com.ktotopawel.aoc2025.day5;

import com.ktotopawel.aoc2025.Utils;

import java.util.HashSet;
import java.util.Set;

public class Cafeteria {
    public static void main(String[] args) {
        IngredientsList input = Utils.readIngredientsList("day5.txt");
//        System.out.println(input);
        System.out.println(countFresh(input));
    }

    public static int countFresh(IngredientsList ingredientsList) {
        var ref = new Object() {
            int count = 0;
        };
        Set<Long> seenIds = new HashSet<>();
        ingredientsList.ids().forEach((id) -> {
           ingredientsList.freshRange().forEach((range) -> {
               if (id >= range.start() && id <= range.end() && !seenIds.contains(id)) {
                   seenIds.add(id);
                   ref.count++;
               }
           });
        });
        return ref.count;
    }
}
