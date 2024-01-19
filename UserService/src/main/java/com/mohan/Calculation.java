package com.mohan;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        // Count the number of escapes for '#' and '!'
        int escapeCount = countEscapes(inputString, '#') + countEscapes(inputString, '!');

        // Output the result
        System.out.println("Number of escapes: " + escapeCount);
    }

    // Function to count the number of escapes for a specific character
    private static int countEscapes(String input, char character) {
        int escapeCount = 0;
        char escapeChar = '\\'; // Backslash character

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == escapeChar && i + 1 < input.length() && input.charAt(i + 1) == character) {
                escapeCount++;
                i++; // Skip the next character since it is escaped
            }
        }

        return escapeCount;
    }
}
