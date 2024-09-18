package org.example.test;

import org.example.Game;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameTest {

    @Test
    public void testGameInitialization() {
        Game game = new Game(4, 2);
        assertNotNull(game.toString(), "Game should be initialized properly.");
    }


}