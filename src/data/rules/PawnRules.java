package data.rules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class PawnRules {

    public static String[] pawnRule(String[][] position, int rowOfPawnInQuestion, int colOfPawnInQuestion, boolean colorOfPawnIsWhite) {
        List<String> listOfValidMoves = new ArrayList<>();

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

            // Check for en passant.
            if (rowOfPawnInQuestion == 3) {
                String[][] an = {
                        {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
                        {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
                        {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
                        {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
                        {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
                        {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
                        {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
                        {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}
                };


                if ((position[rowOfPawnInQuestion][colOfPawnInQuestion + 1].equals("BP") || position[rowOfPawnInQuestion][colOfPawnInQuestion - 1].equals("BP"))) {
                    try {
                        InputStream fis = new FileInputStream("log.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                        String line;
                        List<String> movesSoFar = new ArrayList<>();

                        while ((line = br.readLine()) != null) {
                            movesSoFar.add(line);
                        }

                        String opponentsLastMove = movesSoFar.get(movesSoFar.size() - 1);
                        if (opponentsLastMove.substring(1, 2).equals("7")) {
                            if (an[rowOfPawnInQuestion][colOfPawnInQuestion].charAt(0) - opponentsLastMove.charAt(0) == -1) {
                                listOfValidMoves.add("E" + (rowOfPawnInQuestion - 1) + ", " + (colOfPawnInQuestion + 1));
                            } else if (an[rowOfPawnInQuestion][colOfPawnInQuestion].charAt(0) - opponentsLastMove.charAt(0) == 1) {
                                listOfValidMoves.add("E" + (rowOfPawnInQuestion - 1) + ", " + (colOfPawnInQuestion - 1));
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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

            // Check for en passant.
            if (rowOfPawnInQuestion == 4) {
                String[][] an = {
                        {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
                        {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
                        {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
                        {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
                        {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
                        {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
                        {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
                        {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}
                };


                if ((position[rowOfPawnInQuestion][colOfPawnInQuestion + 1].equals("WP") || position[rowOfPawnInQuestion][colOfPawnInQuestion - 1].equals("WP"))) {
                    try {
                        InputStream fis = new FileInputStream("log.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                        String line;
                        List<String> movesSoFar = new ArrayList<>();

                        while ((line = br.readLine()) != null) {
                            movesSoFar.add(line);
                        }

                        String opponentsLastMove = movesSoFar.get(movesSoFar.size() - 1);
                        if (opponentsLastMove.substring(1, 2).equals("2")) {
                            if (an[rowOfPawnInQuestion][colOfPawnInQuestion].charAt(0) - opponentsLastMove.charAt(0) == -1) {
                                listOfValidMoves.add("E" + (rowOfPawnInQuestion + 1) + ", " + (colOfPawnInQuestion + 1));
                            } else if (an[rowOfPawnInQuestion][colOfPawnInQuestion].charAt(0) - opponentsLastMove.charAt(0) == 1) {
                                listOfValidMoves.add("E" + (rowOfPawnInQuestion + 1) + ", " + (colOfPawnInQuestion - 1));
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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
}
