package org.example.test;

import org.junit.Test;
import org.example.Cell;

import static org.testng.Assert.*;

public class CellTest {

    @Test
    public void testIsMineInitiallyFalse() {
        Cell cell = new Cell();
        assertFalse(cell.isMine(), "New cell should not be a mine initially.");
    }

    @Test
    public void testSetMine() {
        Cell cell = new Cell();
        cell.setMine(true);
        assertTrue(cell.isMine(), "Cell should be a mine after setting it.");
    }

    @Test
    public void testRevealCell() {
        Cell cell = new Cell();
        assertFalse(cell.isRevealed(), "Cell should be hidden initially.");
        cell.reveal();
        assertTrue(cell.isRevealed(), "Cell should be revealed after calling reveal().");
    }

    @Test
    public void testSetAdjacentMines() {
        Cell cell = new Cell();
        cell.setAdjacentMines(3);
        assertEquals(3, cell.getAdjacentMines(), "Cell should correctly store the number of adjacent mines.");
    }

    @Test
    public void testCellToStringHidden() {
        Cell cell = new Cell();
        assertEquals("_", cell.toString(), "Hidden cell should return '_' when calling toString().");
    }

    @Test
    public void testCellToStringRevealedNoMine() {
        Cell cell = new Cell();
        cell.setAdjacentMines(2);
        cell.reveal();
        assertEquals("2", cell.toString(), "Revealed cell should display the number of adjacent mines.");
    }

    @Test
    public void testCellToStringRevealedMine() {
        Cell cell = new Cell();
        cell.setMine(true);
        cell.reveal();
        assertEquals("*", cell.toString(), "Revealed mine cell should return '*' when calling toString().");
    }
}
