package data;

import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class Rules {

// --Commented out by Inspection START (13/05/2015 03:04):
//    public Rules() {
//
//    }
// --Commented out by Inspection STOP (13/05/2015 03:04)

    public static String[] pawnRule(String[][] position, int rowOfPawnInQuestion, int colOfPawnInQuestion, boolean colorOfPawnIsWhite) {
        List<String> listOfValidMoves = new ArrayList<>();

        //System.out.println("COL OF PAWN IN QUESTION: " + colOfPawnInQuestion);
        // Check if pawn is on it's start square
        if (colorOfPawnIsWhite) {
            if (rowOfPawnInQuestion == 6) {
                // The pawn is on it's start square.

                if ((position[rowOfPawnInQuestion - 2][colOfPawnInQuestion].equals("ES")) && (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion].equals("ES"))) {
                    listOfValidMoves.add((rowOfPawnInQuestion - 2) + ", " + colOfPawnInQuestion);
                    listOfValidMoves.add((rowOfPawnInQuestion - 1) + ", " + colOfPawnInQuestion);

                } else if (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMoves.add((rowOfPawnInQuestion - 1) + ", " + colOfPawnInQuestion);
                }

            } else {
                if (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMoves.add((rowOfPawnInQuestion - 1) + ", " + colOfPawnInQuestion);
                }
            }

            // We are now gonna check if the piece can capture anything, but first we need to check if the piece is on the edge of the board so we don't get any array out of bounds exceptions.
            if (colOfPawnInQuestion != 0) {
                if (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion - 1].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfPawnInQuestion - 1) + ", " + (colOfPawnInQuestion - 1));
                }
            }

            if (colOfPawnInQuestion != 7) {
                if ((position[rowOfPawnInQuestion - 1][colOfPawnInQuestion + 1].substring(0, 1).equals("B"))) {
                    listOfValidMoves.add((rowOfPawnInQuestion - 1) + ", " + (colOfPawnInQuestion + 1));
                }
            }

        } else {
            if (rowOfPawnInQuestion == 1) {
                // The pawn is on it's start square.
                if ((position[rowOfPawnInQuestion + 2][colOfPawnInQuestion].equals("ES")) && (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion].equals("ES"))) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 2) + ", " + colOfPawnInQuestion);
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + colOfPawnInQuestion);
                } else if (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + colOfPawnInQuestion);
                }
            } else {
                if (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + colOfPawnInQuestion);
                }
            }

            // We are now gonna check if the piece can capture anything, but first we need to check if the piece is on the edge of the board so we don't get any array out of bounds exceptions.
            if (colOfPawnInQuestion != 7) {
                if (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + (colOfPawnInQuestion + 1));
                }
            }
            if (colOfPawnInQuestion != 0) {
                if (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion - 1].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + (colOfPawnInQuestion - 1));
                }
            }
        }

        return listOfValidMoves.toArray(new String[listOfValidMoves.size()]);
    }

    public static String[] kingRule(String[][] position, int rowOfKingInQuestion, int colOfKingInQuestion, boolean colorOfKingIsWhite) {
        List<String> listOfValidMoves = new ArrayList<>();

        if (colorOfKingIsWhite) {
            // King is white.
            if ((rowOfKingInQuestion == 7) && ((colOfKingInQuestion != 0) && colOfKingInQuestion != 7)) {
                // This will be the most used rule at least until endgame, that's why we are checking for it first.
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + colOfKingInQuestion);
                }

                if ((position[rowOfKingInQuestion -1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion -1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion -1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion -1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }

            else if ((rowOfKingInQuestion == 0) && ((colOfKingInQuestion != 0) && colOfKingInQuestion != 7)) {
                // This will be the most used rule at least until endgame, that's why we are checking for it first.
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + colOfKingInQuestion);
                }
            }




        } else {
            // Kings is black.
            if ((rowOfKingInQuestion == 0) && ((colOfKingInQuestion != 0) && colOfKingInQuestion != 7)) {
                // This will be the most used rule at least until endgame, that's why we are checking for it first.
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + colOfKingInQuestion);
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion +  1) + ", " + (colOfKingInQuestion + 1));
                }
            }

            else if ((rowOfKingInQuestion == 7) && ((colOfKingInQuestion != 0) && colOfKingInQuestion != 7)) {
                // This will be the most used rule at least until endgame, that's why we are checking for it first.
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + colOfKingInQuestion);
                }
            }
        }

        return listOfValidMoves.toArray(new String[listOfValidMoves.size()]);
    }
}
