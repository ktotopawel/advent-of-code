package com.ktotopawel.aoc2025.day5;

import com.ktotopawel.aoc2025.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CafeteriaTest {
    @Test
    public void test() {
        IngredientsList input = Utils.readIngredientsList("day5test.txt");
        assertEquals(3, Cafeteria.countFresh(input));
    }

    @Test
    public void test2() {
        IngredientsList input = Utils.readIngredientsList("day5test.txt");
        assertEquals(21, Cafeteria2.countFresh(input));
    }
}
