package com.ktotopawel.aoc2025;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    private static Path getPath(String filename) throws URISyntaxException {
        var resource = Utils.class.getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + filename);
        }
        return Paths.get(resource.toURI());
    }
}