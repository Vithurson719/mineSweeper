package org.example;

import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    try {
    System.out.println("Welcome to Minesweeper!");
    System.out.print("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
    int size = scanner.nextInt();
    System.out.print("Enter the number of mines to place on the grid: ");
    int mineCount = scanner.nextInt();

    Game game = new Game(size, mineCount);
    game.start();
    }catch(Exception e){
    System.out.println("Invalid Input");
    }
    }
}

