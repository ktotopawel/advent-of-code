package com.ktotopawel.aoc2025;

import com.ktotopawel.aoc2025.day5.IdRange;
import com.ktotopawel.aoc2025.day5.IngredientsList;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {

    /**
     * Reads a file from src/main/resources and returns a list of lines.
     * Useful for puzzles where you process one line at a time.
     */
    public static List<String> readLines(String filename) {
        try {
            return Files.readAllLines(getPath(filename));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

    /**
     * Reads a file from src/main/resources and returns it as one big String.
     * Useful for puzzles where the input is a grid or has blocks separated by empty lines.
     */
    public static String readString(String filename) {
        try {
            return Files.readString(getPath(filename));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

    public static IngredientsList readIngredientsList(String filename) {
        IngredientsList parsed = new IngredientsList(new ArrayList<>(), new ArrayList<>());
        boolean isIds = false;
        try (BufferedReader reader = Files.newBufferedReader(getPath(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isIds && line.isBlank()) {
                    isIds = true;
                    continue;
                }
                if (isIds) {
                    parsed.ids().add(Long.parseLong(line));
                } else {
                    String[] range = line.split("-");
                    IdRange idRange = new IdRange(Long.parseLong(range[0]), Long.parseLong(range[1]));
                    parsed.freshRange().add(idRange);
                }
            }
            return parsed;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }

    private static Path getPath(String filename) throws URISyntaxException {
        var resource = Utils.class.getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + filename);
        }
        return Paths.get(resource.toURI());
    }
}