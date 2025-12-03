package com.ktotopawel.aoc2025.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LobbyTest {
    List<String> input = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");

    @Test
    void testLobby() {
        assertEquals(357, Lobby.getJoltageFromInput(input));
    }
    @Test
    void testLobby2() {
        assertEquals(3_121_910_778_619L, Lobby2.countJoltageFromInput(input));
    }
}
