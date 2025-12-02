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
            System.out.println("Instruction: " + instruction);
            char dir = instruction.charAt(0);
            int clicks = Integer.parseInt(instruction.replaceAll("[\\D]", ""));
            int passedZeroes = Math.floorDiv(clicks, 100);
            res += passedZeroes;
            System.out.println("Added: " + passedZeroes);
            clicks = clicks % 100;
            int newPos = getPosition(pos, dir, clicks);
            if (newPos == 0) {
                System.out.println("Added: " + "1");
                res++;
            }
            System.out.println("New pos: " + newPos);
            System.out.println("Ans after instruction: " + res);
            pos = newPos;
        }
        return res;
    }

    private static int getPosition(int curPos, char dir, int clicks) {
        return dir == 'R' ? (curPos + clicks) % 100 : (curPos - clicks + 100) % 100;
    }
}
