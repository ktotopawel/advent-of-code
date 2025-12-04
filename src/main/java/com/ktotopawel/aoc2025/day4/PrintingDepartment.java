package com.ktotopawel.aoc2025.day4;

import com.ktotopawel.aoc2025.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrintingDepartment {
    public static void main(String[] args) {
        List<String> input = Utils.readLines("day4.txt");

        System.out.println(calculateAccessibleRolls(createMatrixFromInput(input)));
    }

    public static int calculateAccessibleRolls(List<String> strings) {
        return calculateAccessibleRolls(createMatrixFromInput(strings));
    }

    private static int calculateAccessibleRolls(char[][] floorPlan) {
        int ans = 0;

        for (int i = 0; i < floorPlan.length; i++) {
            for (int j = 0; j < floorPlan[0].length; j++) {
                if (floorPlan[i][j] == '.') continue;
                int around = getAround(floorPlan, i, j);
                if (around < 4) {
                    System.out.println("mark: [" + i + ", " + j + "] | around: " + getAround(floorPlan, i, j));
                    ans++;
                };
            }
        }

        return ans;
    }

    private static int getAround(char[][] floorPlan, int i, int j) {
        int around = 0;

        System.out.println("for " + i + ", " + j);

        for (int k = -1; k <= 1; k++) {
            if (i + k < 0 || i + k >= floorPlan.length) continue;
            for (int l = -1; l <= 1; l++) {
                if (j + l < 0 || j + l >= floorPlan[0].length || (j + l == j && i + k == i)) continue;
                System.out.printf("checking %d, %d%n", i + k, j + l);
                if (floorPlan[i + k][j + l] == '@') {
                    around++;
                    System.out.println("hit");
                };
            }
        }
        System.out.println();
        return around;
    }

    private static char[][] createMatrixFromInput(List<String> input) {
        char[][] matrix = new char[input.size()][input.getFirst().length()];
        for (int i = 0; i < input.size(); i++) {
            matrix[i] = input.get(i).toCharArray();
        }
        return matrix;
    }
}
