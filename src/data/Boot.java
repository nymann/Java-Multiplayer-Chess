package data;

import gui.Board;

/**
 * Created by NEX on 12/05/2015.
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
