package org.example;

import java.util.Scanner;

public class Game {
    private final Minefield minefield;
    private final Scanner scanner;

    public Game(Minefield minefield) {
        this.minefield = minefield;
        this.scanner = new Scanner(System.in);
    }

    public Game(int size, int mineCount) {
        this.minefield = new Minefield(size, mineCount);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean gameWon = false;

        while (!gameWon) {
            minefield.display(false);
            String input = getUserInput();

            try {
                if (input.length() < 2) {
                    throw new IllegalArgumentException("Invalid input: Input must be at least 2 characters (e.g., A1).");
                }


                int row = input.charAt(0) - 'A';
                int col = Character.getNumericValue(input.charAt(1)) - 1;

                if (!minefield.revealCell(row, col)) {
                    minefield.display(true);
                    System.out.println("Oh no, you detonated a mine! Game over.");
                    return;
                }

                if (minefield.allNonMineCellsRevealed()) {
                    gameWon = true;
                    minefield.display(true);
                    System.out.println("Congratulations, you have won the game!");
                }

            } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid square in the format (e.g., A1, B2).");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private String getUserInput() {
        System.out.print("Select a square to reveal (e.g. A1): ");
        return scanner.nextLine().toUpperCase().trim();
    }
}
