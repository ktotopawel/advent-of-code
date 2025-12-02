package com.ktotopawel.aoc2025.day1;

import com.ktotopawel.aoc2025.Utils;

import java.util.List;

public class DoorPassword {
    public static void main(String[] args) {
        List<String> lines = Utils.readLines("day1.txt");
        System.out.println("Door password: " + countZeroes(lines));
    }

    public static int countZeroes(List<String> instructions) {
        int pos = 50;
        int res = 0;
        for (String instruction : instructions) {
            pos = getPosition(pos, instruction.charAt(0), Integer.parseInt(instruction.replaceAll("[\\D]", "")));
            if (pos == 0) res++;
        }
        return res;
    }

    private static int getPosition(int curPos, char dir, int clicks) {
        return dir == 'R' ? (curPos + clicks) % 100 : (curPos - clicks + 100) % 100;
    }
}
