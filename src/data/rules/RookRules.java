package data.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class RookRules {
    public static String[] rookRule(String[][] position, int rowOfRookInQuestion, int colOfRookInQuestion, boolean colorOfRookIsWhite) {
        List<String> listOfValidMoves = new ArrayList<>();

        if (colorOfRookIsWhite) {
            // the rook in question is white.

            // The next two for loops is checking for vertical moves.
            for (int i = 1; i <= 7; i++) {
                int added = colOfRookInQuestion + i;

                if (added <= 7) {
                    if (position[rowOfRookInQuestion][colOfRookInQuestion + i].equals("ES")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion + i));
                    } else if (position[rowOfRookInQuestion][colOfRookInQuestion + i].substring(0, 1).equals("B")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                int subtracted = colOfRookInQuestion - i;

                if (subtracted >= 0) {
                    if (position[rowOfRookInQuestion][colOfRookInQuestion - i].equals("ES")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion - i));
                    } else if (position[rowOfRookInQuestion][colOfRookInQuestion - i].substring(0, 1).equals("B")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion - i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // The next two for loops are checking for vertical moves.
            for (int i = 1; i <= 7; i++) {
                int added = rowOfRookInQuestion + i;

                if (added <= 7) {
                    if (position[rowOfRookInQuestion + i][colOfRookInQuestion].equals("ES")) {
                        listOfValidMoves.add((rowOfRookInQuestion + i) + ", " + (colOfRookInQuestion));
                    } else if (position[rowOfRookInQuestion + i][colOfRookInQuestion].substring(0, 1).equals("B")) {
                        listOfValidMoves.add((rowOfRookInQuestion + i) + ", " + (colOfRookInQuestion));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                int subtracted = rowOfRookInQuestion - i;

                if (subtracted >= 0) {
                    if (position[rowOfRookInQuestion - i][colOfRookInQuestion].equals("ES")) {
                        listOfValidMoves.add((rowOfRookInQuestion - i) + ", " + (colOfRookInQuestion));
                    } else if (position[rowOfRookInQuestion - i][colOfRookInQuestion].substring(0, 1).equals("B")) {
                        listOfValidMoves.add((rowOfRookInQuestion - i) + ", " + (colOfRookInQuestion));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }


        } else {
            // Rook is black
            // The next two for loops is checking for vertical moves.
            for (int i = 1; i <= 7; i++) {
                int added = colOfRookInQuestion + i;

                if (added <= 7) {
                    if (position[rowOfRookInQuestion][colOfRookInQuestion + i].equals("ES")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion + i));
                    } else if (position[rowOfRookInQuestion][colOfRookInQuestion + i].substring(0, 1).equals("W")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                int subtracted = colOfRookInQuestion - i;

                if (subtracted >= 0) {
                    if (position[rowOfRookInQuestion][colOfRookInQuestion - i].equals("ES")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion - i));
                    } else if (position[rowOfRookInQuestion][colOfRookInQuestion - i].substring(0, 1).equals("W")) {
                        listOfValidMoves.add(rowOfRookInQuestion + ", " + (colOfRookInQuestion - i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            // The next two for loops are checking for vertical moves.
            for (int i = 1; i <= 7; i++) {
                int added = rowOfRookInQuestion + i;

                if (added <= 7) {
                    if (position[rowOfRookInQuestion + i][colOfRookInQuestion].equals("ES")) {
                        listOfValidMoves.add((rowOfRookInQuestion + i) + ", " + (colOfRookInQuestion));
                    } else if (position[rowOfRookInQuestion + i][colOfRookInQuestion].substring(0, 1).equals("W")) {
                        listOfValidMoves.add((rowOfRookInQuestion + i) + ", " + (colOfRookInQuestion));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }

            for (int i = 1; i <= 7; i++) {
                int subtracted = rowOfRookInQuestion - i;

                if (subtracted >= 0) {
                    if (position[rowOfRookInQuestion - i][colOfRookInQuestion].equals("ES")) {
                        listOfValidMoves.add((rowOfRookInQuestion - i) + ", " + (colOfRookInQuestion));
                    } else if (position[rowOfRookInQuestion - i][colOfRookInQuestion].substring(0, 1).equals("W")) {
                        listOfValidMoves.add((rowOfRookInQuestion - i) + ", " + (colOfRookInQuestion));
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
