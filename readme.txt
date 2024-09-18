Minesweeper Game
Overview
This project implements a command-line version of the classic Minesweeper game. The game starts by prompting the user to input the grid size and the number of mines. The user then reveals cells one by one until they either uncover all non-mine cells (win) or hit a mine (lose). The game provides appropriate messages for winning and losing conditions.

Features

Initialize the game with a customizable grid size and number of mines.
Reveal cells based on user input.
Automatically uncover adjacent cells if the selected cell has no adjacent mines.
Display the current state of the minefield after each move.
Handle invalid inputs gracefully with error messages.

Start the game:

The program will prompt you to enter the size of the grid (e.g., 4 for a 4x4 grid).
Enter the number of mines to place on the grid (maximum is 35% of the total squares).
Play the game:

The minefield will be displayed with cells marked as _.
Select a square to reveal by entering its coordinates (e.g., A1).
The game will display the number of adjacent mines or automatically uncover adjacent cells if there are no nearby mines.
Game End:

If you hit a mine, the game will end and reveal the full minefield.
If you uncover all non-mine cells, you win the game!