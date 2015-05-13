package data.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class BishopRules {

    public static String[] bishopRule(String[][] position, int rowOfBishopInQuestion, int colOfBishopInQuestion, boolean colorOfBishopIsWhite) {

        List<String> listOfValidMoves = new ArrayList<>();

        if (colorOfBishopIsWhite) {
            // The bishop is white.

            // possible bishop moves in the left up direction. The MAXIMUM amount of possible moves for this diagonal is decided by the COL of the Bishop.
            for (int i = 1; i <= colOfBishopInQuestion; i++) {
                if ((colOfBishopInQuestion - i >= 0) && (rowOfBishopInQuestion - i >= 0)) {
                    if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion - i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion - i));
                    } else if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion - i].substring(0, 1).equals("B")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion - i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // possible bishop moves in the right up direction. The MAXIMUM amount of possible moves for this diagonal is decided by the ROW of the Bishop
            //System.out.println(rowOfBishopInQuestion);
            System.out.println("row: " + rowOfBishopInQuestion);
            for (int i = 1; i <= rowOfBishopInQuestion; i++) {
                if ((colOfBishopInQuestion + i <= 7) && (rowOfBishopInQuestion - i >= 0)) {
                    if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion + i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion + i));
                    } else if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion + i].substring(0, 1).equals("B")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // possible bishop moves in the right down direction. The MAXIMUM amount of possible moves for this diagonal is decided by 7 - ROW.
            for (int i = 1; i <= (7 - rowOfBishopInQuestion); i++) {
                if ((colOfBishopInQuestion + i <= 7) && (rowOfBishopInQuestion + i <= 7)) {
                    if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion + i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion + i));
                    } else if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion + i].substring(0, 1).equals("B")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // possible bishop moves in the right left direction. The MAXIMUM amount of possible moves for this diagonal is decided by COL.
            for (int i = 1; i <= colOfBishopInQuestion; i++) {
                if ((colOfBishopInQuestion - i >= 0) && (rowOfBishopInQuestion + i <= 7)) {
                    if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion - i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion - i));
                    } else if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion - i].substring(0, 1).equals("B")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion - i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

        } else {
            // The bishop is black.
            // possible bishop moves in the left up direction. The MAXIMUM amount of possible moves for this diagonal is decided by the COL of the Bishop.
            for (int i = 1; i <= colOfBishopInQuestion; i++) {
                if ((colOfBishopInQuestion - i >= 0) && (rowOfBishopInQuestion - i >= 0)) {
                    if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion - i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion - i));
                    } else if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion - i].substring(0, 1).equals("W")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion - i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // possible bishop moves in the right up direction. The MAXIMUM amount of possible moves for this diagonal is decided by the ROW of the Bishop
            for (int i = 1; i <= rowOfBishopInQuestion; i++) {
                if ((colOfBishopInQuestion + i <= 7) && (rowOfBishopInQuestion - i >= 0)) {
                    if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion + i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion + i));
                    } else if (position[rowOfBishopInQuestion - i][colOfBishopInQuestion + i].substring(0, 1).equals("W")) {
                        listOfValidMoves.add((rowOfBishopInQuestion - i) + ", " + (colOfBishopInQuestion + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // possible bishop moves in the right down direction. The MAXIMUM amount of possible moves for this diagonal is decided by 7 - ROW.
            for (int i = 1; i <= (7 - rowOfBishopInQuestion); i++) {
                if ((colOfBishopInQuestion + i <= 7) && (rowOfBishopInQuestion + i <= 7)) {
                    if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion + i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion + i));
                    } else if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion + i].substring(0, 1).equals("W")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // possible bishop moves in the right left direction. The MAXIMUM amount of possible moves for this diagonal is decided by COL.
            for (int i = 1; i <= colOfBishopInQuestion; i++) {
                if ((colOfBishopInQuestion - i >= 0) && (rowOfBishopInQuestion + i <= 7)) {
                    if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion - i].equals("ES")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion - i));
                    } else if (position[rowOfBishopInQuestion + i][colOfBishopInQuestion - i].substring(0, 1).equals("W")) {
                        listOfValidMoves.add((rowOfBishopInQuestion + i) + ", " + (colOfBishopInQuestion - i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        return listOfValidMoves.toArray(new String[listOfValidMoves.size()]);
    }
}
