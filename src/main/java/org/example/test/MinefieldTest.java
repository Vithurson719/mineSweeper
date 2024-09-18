package org.example.test;

import org.example.Minefield;
import org.junit.Test;

import static org.testng.Assert.*;


public class MinefieldTest {

    @Test
    public void testMinefieldCreation() {
        Minefield minefield = new Minefield(5, 3);
        assertNotNull(minefield, "Minefield should be created.");
    }

    @Test
    public void testMinePlacement() {
        Minefield minefield = new Minefield(4, 2);
        int mineCount = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (minefield.revealCell(row, col) == false) {
                    mineCount++;
                }
            }
        }
        assertEquals(2, mineCount, "There should be exactly 2 mines placed.");
    }

    @Test
    public void testRevealCell() {
        Minefield minefield = new Minefield(4, 2);
        assertTrue(minefield.revealCell(0, 0), "Revealing a non-mine cell should return true.");
    }

    @Test
    public void testRevealMineCell() {
        Minefield minefield = new Minefield(4, 1);
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (!minefield.revealCell(row, col)) {
                    assertFalse(minefield.revealCell(row, col), "Revealing a mine cell should return false.");
                    return;
                }
            }
        }
    }

    @Test
    public void testRevealAdjacentCells() {
        Minefield minefield = new Minefield(3, 1);
        minefield.revealCell(0, 0);

    }
}

