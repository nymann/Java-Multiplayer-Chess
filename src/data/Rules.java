package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristian on 12/05/2015.
 */
public class Rules {

    public Rules() {

    }

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
            if(colOfPawnInQuestion != 0) {
                if ((!position[rowOfPawnInQuestion - 1][colOfPawnInQuestion - 1].equals("ES")) && (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].substring(0, 1).equals("B"))) {
                    listOfValidMoves.add((rowOfPawnInQuestion - 1) + ", " + (colOfPawnInQuestion - 1));
                }
            }

            if (colOfPawnInQuestion != 7) {
                if ((!position[rowOfPawnInQuestion - 1][colOfPawnInQuestion + 1].equals("ES")) && (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].substring(0, 1).equals("B"))) {
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
                if ((!position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].equals("ES")) && (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].substring(0, 1).equals("W"))) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + (colOfPawnInQuestion + 1));
                }
            }
            if (colOfPawnInQuestion != 0) {
                if ((!position[rowOfPawnInQuestion + 1][colOfPawnInQuestion - 1].equals("ES")) && (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].substring(0, 1).equals("W"))) {
                    listOfValidMoves.add((rowOfPawnInQuestion + 1) + ", " + (colOfPawnInQuestion - 1));
                }
            }
        }

        String[] finalList = listOfValidMoves.toArray(new String[listOfValidMoves.size()]);
        
        return finalList;
    }

    public static String[] bishopRule(String[][] position, int rowOfBishopInQuestion, int colOfBishopInQuestion, boolean colorOfBishopIsWhite) {

    }
}
