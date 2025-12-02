package com.ktotopawel.aoc2025.day1;

import com.ktotopawel.aoc2025.Utils;

import java.util.List;

public class DoorPassword2 {
    public static void main(String[] args) {
        List<String> lines = Utils.readLines("day1.txt");
        System.out.println("Door password: " + countZeroes(lines));
    }

    public static int countZeroes(List<String> instructions) {
        int pos = 50;
        int res = 0;
        for (String instruction : instructions) {

            System.out.println("Position: " + pos);
            System.out.println("Instruction: " + instruction);

            int clicks = Integer.parseInt(instruction.replaceAll("[\\D]", ""));
            char dir = instruction.charAt(0);
            int passedZeroes = Math.floorDiv(clicks, 100);

            System.out.println("Full rotations: " + passedZeroes);

            int newPos = dir == 'R' ? pos + (clicks % 100) : pos - (clicks % 100);

            System.out.println("Newpos: " + newPos);

            if (pos != 0 && (newPos <= 0 || newPos >= 100)) {
                passedZeroes++;
            }
            ;
            pos = (newPos + 100) % 100;

            res += passedZeroes;

            System.out.println("Added: " + passedZeroes);
            System.out.println("Ans: " + res);
            System.out.println();
        }
        return res;
    }
}
