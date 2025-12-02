package com.ktotopawel.aoc2025.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DoorPassword2Test {
    @Test
    public void testDoorPassword() {
        List<String> input = List.of(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82"
        );

        Assertions.assertEquals(6, DoorPassword2.countZeroes(input));
    }
}
