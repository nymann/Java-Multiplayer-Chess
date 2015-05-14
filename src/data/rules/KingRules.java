package data.rules;

import gui.Board;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */


public class KingRules {

    public static String[] kingRule(String[][] position, int rowOfKingInQuestion, int colOfKingInQuestion, boolean colorOfKingIsWhite) {
        // CURRENTLY MISSING castling both directions, is in check, and is checkmated.
        boolean kingsideCastle = true;
        boolean queensideCastle = true;
        List<String> listOfValidMoves = new ArrayList<>();

        if (colorOfKingIsWhite) {
            // King is white.

            // Checking for the ability to castle kingside.
            if ((rowOfKingInQuestion == 7) && (colOfKingInQuestion == 4)) {
                // The king is on it's start square, now checking if the two squares to the right of the king is empty and the third is a rook.

                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion + 2].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion + 3].equals("WR"))) {
                    try {
                        // Some of the following is borrowed by Ramin as seen in: http://stackoverflow.com/questions/13405822/using-bufferedreader-readline-in-a-while-loop-properly
                        InputStream fis = new FileInputStream("log.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                        for (String line = br.readLine(); line != null; line = br.readLine()) {
                            if (line.contains("e1") || line.contains("h1")) {
                                kingsideCastle = false;
                                break;
                            }
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (kingsideCastle) {
                        listOfValidMoves.add("WKC");
                    }
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion - 2].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion - 3].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion - 4].equals("WR"))) {
                    try {
                        // Some of the following is borrowed by Ramin as seen in: http://stackoverflow.com/questions/13405822/using-bufferedreader-readline-in-a-while-loop-properly
                        InputStream fis = new FileInputStream("log.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                        for (String line = br.readLine(); line != null; line = br.readLine()) {
                            if (line.contains("e1") || line.contains("h1")) {
                                queensideCastle = false;
                                break;
                            }
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (queensideCastle) {
                        //System.out.println("Queen side castling possible.");
                        listOfValidMoves.add("WQC");
                    }
                }

            }

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

            // Checking for the ability to castle.
            if ((rowOfKingInQuestion == 0) && (colOfKingInQuestion == 4)) {
                // The king is on it's start square, now checking if the two squares to the right of the king is empty and the third is a rook.
                if ((position[rowOfKingInQuestion][colOfKingInQuestion + 1].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion + 2].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion + 3].equals("BR"))) {
                    try {
                        // Some of the following is borrowed by Ramin as seen in: http://stackoverflow.com/questions/13405822/using-bufferedreader-readline-in-a-while-loop-properly
                        InputStream fis = new FileInputStream("log.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                        for (String line = br.readLine(); line != null; line = br.readLine()) {
                            if (line.contains("e1") || line.contains("h1")) {
                                kingsideCastle = false;
                                break;
                            }
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (kingsideCastle) {
                        listOfValidMoves.add("BKC");
                    }
                }

                if ((position[rowOfKingInQuestion][colOfKingInQuestion - 1].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion - 2].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion - 3].equals("ES")) && (position[rowOfKingInQuestion][colOfKingInQuestion - 4].equals("BR"))) {
                    try {
                        // Some of the following is borrowed by Ramin as seen in: http://stackoverflow.com/questions/13405822/using-bufferedreader-readline-in-a-while-loop-properly
                        InputStream fis = new FileInputStream("log.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

                        for (String line = br.readLine(); line != null; line = br.readLine()) {
                            if (line.contains("e1") || line.contains("h1")) {
                                queensideCastle = false;
                                break;
                            }
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (queensideCastle) {
                        listOfValidMoves.add("BQC");
                    }
                }
            }

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
