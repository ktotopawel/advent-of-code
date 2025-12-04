package com.ktotopawel.aoc2025.day4;

import com.ktotopawel.aoc2025.Utils;

import java.util.*;

public class PrintingDepartment2 {
    public static void main(String[] args) {
        List<String> input = Utils.readLines("day4.txt");
        System.out.println(solve(input));
    }

    public static long solve(List<String> input) {
        char[][] matrix = createMatrixFromInput(input);

        return removeAndCountRolls(matrix, getAccessibleRollsCoords(matrix));
    }


    private static long removeAndCountRolls(char[][] floorPlan, List<int[]> accessibleRolls) {
        long ans = 0;
        LinkedList<int[]> queue = new LinkedList<>(accessibleRolls);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            if (floorPlan[cur[0]][cur[1]] == '@') {
                floorPlan[cur[0]][cur[1]] = '.';
                ans++;
            } else {
                continue;
            }

            for (int k = -1; k <= 1; k++) {
                if (i + k < 0 || i + k >= floorPlan.length) continue;
                for (int l = -1; l <= 1; l++) {
                    if (j + l < 0 || j + l >= floorPlan[0].length) continue;
                    if (floorPlan[i + k][j + l] == '@') {
                        int rollsAround = getAround(floorPlan, i + k, j + l);
                        if (rollsAround < 4) queue.add(new int[]{i + k, j + l});
                    }
                }
            }
        }
        return ans;
    }

    // finds all roots?

    private static List<int[]> getAccessibleRollsCoords(char[][] floorPlan) {
        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < floorPlan.length; i++) {
            for (int j = 0; j < floorPlan[0].length; j++) {
                if (floorPlan[i][j] != '@') continue;
                int around = getAround(floorPlan, i, j);
                if (around < 4) {
                    ans.add(new int[]{i, j});
                };
            }
        }

        return ans;
    }

    private static int getAround(char[][] floorPlan, int i, int j) {
        int around = 0;
        for (int k = -1; k <= 1; k++) {
            if (i + k < 0 || i + k >= floorPlan.length) continue;
            for (int l = -1; l <= 1; l++) {
                if (j + l < 0 || j + l >= floorPlan[0].length || (j + l == j && i + k == i)) continue;
                if (floorPlan[i + k][j + l] == '@') {
                    around++;
                };
            }
        }
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
