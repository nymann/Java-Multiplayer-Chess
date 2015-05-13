package data;

import gui.Board;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */

public class Boot {

    String[][] boardView = {
            {"BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR"},
            {"BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"},
            {"WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR"}
    };

    String[][] testBoard = {
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "BB", "BB", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "WB", "ES", "ES", "ES", "ES", "ES", "WB"},
            {"ES", "WB", "ES", "ES", "ES", "ES", "ES", "ES"},
            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
    };

    public Boot() {
        gui.Board guiBoard = new Board();
        guiBoard.createTheBoard();
        guiBoard.newGame(boardView);
        guiBoard.makeButtonsInteractive();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
