package data.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */


public class KingRules {

    public static String[] kingRule(String[][] position, int rowOfKingInQuestion, int colOfKingInQuestion, boolean colorOfKingIsWhite) {
        // CURRENTLY MISSING castling both directions, is in check, and is checkmated.

        List<String> listOfValidMoves = new ArrayList<>();

        if (colorOfKingIsWhite) {
            // King is white.

            // Checking the row 0, which is the black kings start row.
            if ((rowOfKingInQuestion == 0) && ((colOfKingInQuestion != 0) && (colOfKingInQuestion != 7))) {
                // From this criteria there is up to 5 legal moves for every king position.

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }
            }

            // Checking the row 7, which is the white kings start row.
            else if ((rowOfKingInQuestion == 7) && ((colOfKingInQuestion != 0) && (colOfKingInQuestion != 7))) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }

            // Checking the colon which is furthest to the left on the board (0).
            else if ((colOfKingInQuestion == 0) && ((rowOfKingInQuestion != 0) && (rowOfKingInQuestion != 7))) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }

            // Checking the colon which is furthest to the right on the board (7).
            else if ((colOfKingInQuestion == 7) && ((rowOfKingInQuestion != 0) && (rowOfKingInQuestion != 7))) {
                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }
            }

            // checking if the king is placed in the upper left corner.
            else if(colOfKingInQuestion == 0 && rowOfKingInQuestion == 0) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + colOfKingInQuestion);
                }
            }

            // checking if the king is placed in the upper right corner.
            else if (colOfKingInQuestion == 7 && rowOfKingInQuestion == 0) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }
                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + colOfKingInQuestion);
                }
            }

            // checking if the king is placed in the lower right corner.
            else if((colOfKingInQuestion == 7) & (rowOfKingInQuestion == 7)) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + colOfKingInQuestion);
                }
            }

            // checking if the king is placed in the lower left corner.
            else if((colOfKingInQuestion == 0) & (rowOfKingInQuestion == 7)) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + colOfKingInQuestion);
                }
            }

            else {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("B"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }

        } else {
            // Kings is black.

            // Checking the row 0, which is the black kings start row.
            if ((rowOfKingInQuestion == 0) && ((colOfKingInQuestion != 0) && (colOfKingInQuestion != 7))) {
                // From this criteria there is up to 5 legal moves for every king position.

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }
            }

            // Checking the row 7, which is the white kings start row.
            else if ((rowOfKingInQuestion == 7) && ((colOfKingInQuestion != 0) && (colOfKingInQuestion != 7))) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }

            // Checking the colon which is furthest to the left on the board (0).
            else if ((colOfKingInQuestion == 0) && ((rowOfKingInQuestion != 0) && (rowOfKingInQuestion != 7))) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }

            // Checking the colon which is furthest to the right on the board (7).
            else if ((colOfKingInQuestion == 7) && ((rowOfKingInQuestion != 0) && (rowOfKingInQuestion != 7))) {
                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }
            }

            // checking if the king is placed in the upper left corner.
            else if(colOfKingInQuestion == 0 && rowOfKingInQuestion == 0) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + colOfKingInQuestion);
                }
            }

            // checking if the king is placed in the upper right corner.
            else if (colOfKingInQuestion == 7 && rowOfKingInQuestion == 0) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }
                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + colOfKingInQuestion);
                }
            }

            // checking if the king is placed in the lower right corner.
            else if((colOfKingInQuestion == 7) & (rowOfKingInQuestion == 7)) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + colOfKingInQuestion);
                }
            }

            // checking if the king is placed in the lower left corner.
            else if((colOfKingInQuestion == 0) & (rowOfKingInQuestion == 7)) {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add(rowOfKingInQuestion + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + colOfKingInQuestion);
                }
            }

            else {
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion + 1));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion + 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion + 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion - 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion - 1));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion));
                }

                if ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].equals("ES")) || ((position[rowOfKingInQuestion - 1][colOfKingInQuestion + 1].substring(0, 1)).equals("W"))) {
                    listOfValidMoves.add((rowOfKingInQuestion - 1) + ", " + (colOfKingInQuestion + 1));
                }
            }
        }

        return listOfValidMoves.toArray(new String[listOfValidMoves.size()]);
    }
}
