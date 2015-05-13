package data.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class KnightRules {

    public static String[] knightRule(String[][] position, int rowOfKnightInQuestion, int colOfKnightInQuestion, boolean colorOfKnightIsWhite) {

        List<String> listOfValidMoves = new ArrayList<>();

        if (colorOfKnightIsWhite) {
            // The knight is white.

            // Checking all the knight moves in clockwise direction, starting with COL+2, ROW +1. FX ROW 4 COL 3 to ROW 5 COL 5.
            if ((colOfKnightInQuestion <= 5) && (rowOfKnightInQuestion <= 6)) {
                if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion + 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion + 2));
                }
                else if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion + 2].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion + 2));
                }
            }

            if ((colOfKnightInQuestion <= 6 ) && (rowOfKnightInQuestion <= 5)) {
                if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion + 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion + 1));
                }
                else if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion + 1].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion + 1));
                }
            }

            if ((colOfKnightInQuestion >= 1) && (rowOfKnightInQuestion <= 5)) {
                if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion - 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion - 1));
                }
                else if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion - 1].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion - 1));
                }
            }

            if ((colOfKnightInQuestion >= 2) && (rowOfKnightInQuestion <= 6)) {
                if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion - 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion - 2));
                }
                else if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion - 2].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion - 2));
                }
            }

            if ((colOfKnightInQuestion >= 2) && (rowOfKnightInQuestion >= 1)) {
                if (position[rowOfKnightInQuestion - 1][colOfKnightInQuestion - 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion - 2));
                }
                else if(position[rowOfKnightInQuestion - 1][colOfKnightInQuestion - 2].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion - 2));
                }
            }

            if ((colOfKnightInQuestion >= 1) && (rowOfKnightInQuestion >= 2)) {
                if (position[rowOfKnightInQuestion - 2][colOfKnightInQuestion - 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion - 1));
                }
                else if(position[rowOfKnightInQuestion - 1][colOfKnightInQuestion - 1].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion - 1));
                }
            }

            if ((colOfKnightInQuestion <= 6) && (rowOfKnightInQuestion >= 2)) {
                if (position[rowOfKnightInQuestion - 2][colOfKnightInQuestion + 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion + 1));
                }
                else if(position[rowOfKnightInQuestion - 2][colOfKnightInQuestion + 1].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion + 1));
                }
            }

            if ((colOfKnightInQuestion <= 5) && (rowOfKnightInQuestion >= 1)) {
                if (position[rowOfKnightInQuestion - 1][colOfKnightInQuestion + 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion + 2));
                }
                else if(position[rowOfKnightInQuestion - 1][colOfKnightInQuestion + 2].substring(0, 1).equals("B")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion + 2));
                }
            }
        }

        else {
            // The knight is black.
            if ((colOfKnightInQuestion <= 5) && (rowOfKnightInQuestion <= 6)) {
                if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion + 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion + 2));
                }
                else if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion + 2].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion + 2));
                }
            }

            if ((colOfKnightInQuestion <= 6 ) && (rowOfKnightInQuestion <= 5)) {
                if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion + 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion + 1));
                }
                else if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion + 1].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion + 1));
                }
            }

            if ((colOfKnightInQuestion >= 1) && (rowOfKnightInQuestion <= 5)) {
                if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion - 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion - 1));
                }
                else if (position[rowOfKnightInQuestion + 2][colOfKnightInQuestion - 1].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 2) + ", " + (colOfKnightInQuestion - 1));
                }
            }

            if ((colOfKnightInQuestion >= 2) && (rowOfKnightInQuestion <= 6)) {
                if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion - 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion - 2));
                }
                else if (position[rowOfKnightInQuestion + 1][colOfKnightInQuestion - 2].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion + 1) + ", " + (colOfKnightInQuestion - 2));
                }
            }

            if ((colOfKnightInQuestion >= 2) && (rowOfKnightInQuestion >= 1)) {
                if (position[rowOfKnightInQuestion - 1][colOfKnightInQuestion - 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion - 2));
                }
                else if(position[rowOfKnightInQuestion - 1][colOfKnightInQuestion - 2].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion - 2));
                }
            }

            if ((colOfKnightInQuestion >= 1) && (rowOfKnightInQuestion >= 2)) {
                if (position[rowOfKnightInQuestion - 2][colOfKnightInQuestion - 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion - 1));
                }
                else if(position[rowOfKnightInQuestion - 1][colOfKnightInQuestion - 1].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion - 1));
                }
            }

            if ((colOfKnightInQuestion <= 6) && (rowOfKnightInQuestion >= 2)) {
                if (position[rowOfKnightInQuestion - 2][colOfKnightInQuestion + 1].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion + 1));
                }
                else if(position[rowOfKnightInQuestion - 2][colOfKnightInQuestion + 1].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 2) + ", " + (colOfKnightInQuestion + 1));
                }
            }

            if ((colOfKnightInQuestion <= 5) && (rowOfKnightInQuestion >= 1)) {
                if (position[rowOfKnightInQuestion - 1][colOfKnightInQuestion + 2].equals("ES")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion + 2));
                }
                else if(position[rowOfKnightInQuestion - 1][colOfKnightInQuestion + 2].substring(0, 1).equals("W")) {
                    listOfValidMoves.add((rowOfKnightInQuestion - 1) + ", " + (colOfKnightInQuestion + 2));
                }
            }
        }

        return listOfValidMoves.toArray(new String[listOfValidMoves.size()]);
    }
}
