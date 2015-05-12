package data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Kristian on 12/05/2015.
 */
public class Rules {

    public Rules() {

    }

    public static int[][] pawnRule(String[][] position, int rowOfPawnInQuestion, int colOfPawnInQuestion, boolean colorOfPawnIsWhite) {
        List<Integer> listOfValidMovesRow = new ArrayList<>();
        List<Integer> listOfValidMovesCol = new ArrayList<>();
        // Check if pawn is on it's start square
        if (colorOfPawnIsWhite) {
            if (rowOfPawnInQuestion == 6) {
                // The pawn is on it's start square.

                if ((position[rowOfPawnInQuestion - 2][colOfPawnInQuestion].equals("ES")) && (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion].equals("ES"))) {
                    listOfValidMovesRow.add(rowOfPawnInQuestion - 2);
                    listOfValidMovesRow.add(colOfPawnInQuestion);

                    listOfValidMovesRow.add(rowOfPawnInQuestion -1);
                    listOfValidMovesCol.add(colOfPawnInQuestion);
                }

                else if (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMovesRow.add(rowOfPawnInQuestion - 1);
                    listOfValidMovesCol.add(colOfPawnInQuestion);
                }
            }

            else {
                if (position[rowOfPawnInQuestion - 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMovesRow.add(rowOfPawnInQuestion - 1);
                    listOfValidMovesCol.add(colOfPawnInQuestion);
                }
            }

            // Remember to check for capturable piece.
            if (!position[rowOfPawnInQuestion - 1][colOfPawnInQuestion - 1].equals("ES")) {
                listOfValidMovesRow.add(rowOfPawnInQuestion - 1);
                listOfValidMovesCol.add(colOfPawnInQuestion - 1);
            }

            if (!position[rowOfPawnInQuestion - 1][colOfPawnInQuestion + 1].equals("ES")) {
                listOfValidMovesRow.add(rowOfPawnInQuestion - 1);
                listOfValidMovesCol.add(colOfPawnInQuestion + 1);
            }

        }

        else {
            if (rowOfPawnInQuestion == 1) {
                // The pawn is on it's start square.
                if ((position[rowOfPawnInQuestion + 2][colOfPawnInQuestion].equals("ES")) && (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion].equals("ES"))) {
                    listOfValidMovesRow.add(rowOfPawnInQuestion + 2);
                    listOfValidMovesRow.add(colOfPawnInQuestion);

                    listOfValidMovesRow.add(rowOfPawnInQuestion + 1);
                    listOfValidMovesCol.add(colOfPawnInQuestion);
                }

                else if (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMovesRow.add(rowOfPawnInQuestion + 1);
                    listOfValidMovesCol.add(colOfPawnInQuestion);
                }
            }

            else {
                if (position[rowOfPawnInQuestion + 1][colOfPawnInQuestion].equals("ES")) {
                    listOfValidMovesRow.add(rowOfPawnInQuestion + 1);
                    listOfValidMovesCol.add(colOfPawnInQuestion);
                }
            }

            // Remember to check for capturable piece.
            if (!position[rowOfPawnInQuestion + 1][colOfPawnInQuestion + 1].equals("ES")) {
                listOfValidMovesRow.add(rowOfPawnInQuestion + 1);
                listOfValidMovesCol.add(colOfPawnInQuestion + 1);
            }

            if (!position[rowOfPawnInQuestion + 1][colOfPawnInQuestion - 1].equals("ES")) {
                listOfValidMovesRow.add(rowOfPawnInQuestion + 1);
                listOfValidMovesCol.add(colOfPawnInQuestion - 1);
            }
        }

        int[] rowsToIntArray = ArrayUtils.toPrimitive(listOfValidMovesRow.toArray(new Integer[listOfValidMovesRow.size()]));
        int[] colsToIntArray = ArrayUtils.toPrimitive(listOfValidMovesCol.toArray(new Integer[listOfValidMovesCol.size()]));

        int[][] listOfValidMoves = {rowsToIntArray, colsToIntArray};

        return listOfValidMoves;
    }

}
