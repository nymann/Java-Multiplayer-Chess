package data;

import gui.Board;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */

class Boot {

    // --Commented out by Inspection START (14/05/2015 03:38):
// --Commented out by Inspection START (14/05/2015 03:50):
//    String[][] testBoard = {
//            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
//            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
//            {"ES", "ES", "BP", "ES", "BP", "ES", "ES", "ES"},
//            {"ES", "BP", "ES", "ES", "ES", "BP", "ES", "ES"},
//            {"ES", "ES", "ES", "WN", "ES", "ES", "ES", "ES"},
//            {"ES", "BP", "ES", "ES", "ES", "BP", "ES", "ES"},
//            {"ES", "ES", "BP", "ES", "BP", "ES", "ES", "ES"},
//            {"ES", "ES", "ES", "ES", "ES", "ES", "ES", "ES"},
//    };
// --Commented out by Inspection STOP (14/05/2015 03:50)


    private Boot() {
        Log.deletePreviousLog();
        gui.Board guiBoard = new Board();
        guiBoard.createTheBoard();
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
        guiBoard.newGame(boardView);
        guiBoard.makeButtonsInteractive();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
