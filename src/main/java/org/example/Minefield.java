package org.example;
import java.util.Random;

public class Minefield {
    private final int size;
    private final int mineCount;
    private final Cell[][] grid;

    public Minefield(int size, int mineCount) {
        this.size = size;
        this.mineCount = mineCount;
        this.grid = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }

        placeMines();
        calculateAdjacentMines();
    }

    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < mineCount) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            if (!grid[row][col].isMine()) {
                grid[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (!grid[row][col].isMine()) {
                    grid[row][col].setAdjacentMines(countAdjacentMines(row, col));
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isInBounds(row + i, col + j) && grid[row + i][col + j].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isInBounds(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean revealCell(int row, int col) {
        if (grid[row][col].isMine()) {
            return false;
        }
        revealAdjacentCells(row, col);
        return true;
    }

    private void revealAdjacentCells(int row, int col) {
        if (!isInBounds(row, col) || grid[row][col].isRevealed()) {
            return;
        }

        grid[row][col].reveal();

        if (grid[row][col].getAdjacentMines() == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealAdjacentCells(row + i, col + j);
                }
            }
        }
    }

    public boolean allNonMineCellsRevealed() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!grid[i][j].isMine() && !grid[i][j].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void display(boolean revealAll) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int col = 0; col < size; col++) {
                if (revealAll) {
                    grid[row][col].reveal();
                }
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}