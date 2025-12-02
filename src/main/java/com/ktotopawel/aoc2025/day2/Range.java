package com.ktotopawel.aoc2025.day2;

import java.util.Arrays;
import java.util.List;

public record Range(long start, long end) {

    public static Range fromString(String s) {
        long[] split = Arrays.stream(s.split("-")).mapToLong(Long::parseLong).toArray();
        return new Range(split[0], split[1]);
    }

    public static List<Range> fromInput(String input) {
        return Arrays.stream(input.trim().split(",")).map(Range::fromString).toList();
    }
}
