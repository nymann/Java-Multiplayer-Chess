package data.rules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            // Checking for the ability to castle kingside.
            if ((rowOfKingInQuestion == 7) && (colOfKingInQuestion == 4)) {
                // The king is on it's start square, now checking if the two squares to the right of the king is empty and the third is a rook.
                kingsideCastleCheck:
                for (int i = 1; i <= 2; i++) {
                    if (position[rowOfKingInQuestion][colOfKingInQuestion + i].equals("ES")) {
                        if (position[rowOfKingInQuestion][colOfKingInQuestion + i + 1].equals("WR")) {
                            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("res/log.txt"))) {
                                String line;

                                while ((line = bufferedReader.readLine()) != null) {
                                    if (line.contains("e1") || line.contains("h1")) {
                                        System.out.println("kingside castling is not an option");
                                        break kingsideCastleCheck;
                                    }
                                }

                                System.out.println("Kingside castling is an option!");

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                queensideCastleCheck:
                for (int i = 1; i < 3; i++) {
                    if (position[rowOfKingInQuestion][colOfKingInQuestion - i].equals("ES")) {
                        if (position[rowOfKingInQuestion][colOfKingInQuestion - i - 1].equals("ES")) {
                            if (position[rowOfKingInQuestion][colOfKingInQuestion - i - 2].equals("WR")) {
                                try (BufferedReader bufferedReader = new BufferedReader(new FileReader("res/log.txt"))) {
                                    String line;

                                    while ((line = bufferedReader.readLine()) != null) {
                                        if (line.contains("e1") || line.contains("a1")) {
                                            System.out.println("kingside castling is not an option");
                                            break queensideCastleCheck;
                                        }
                                    }

                                    System.out.println("Queenside castling is an option!");

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
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
                System.out.println("YO");
                // The king is on it's start square, now checking if the two squares to the right of the king is empty and the third is a rook.
                kingsideCastleCheck:
                for (int i = 1; i <= 2; i++) {
                    if (position[rowOfKingInQuestion][colOfKingInQuestion + i].equals("ES")) {
                        if (position[rowOfKingInQuestion][colOfKingInQuestion + i + 1].equals("WR")) {
                            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("res/log.txt"))) {
                                String line;

                                while ((line = bufferedReader.readLine()) != null) {
                                    if (line.contains("e8") || line.contains("h8")) {
                                        System.out.println("kingside castling is not an option");
                                        break kingsideCastleCheck;
                                    }
                                }

                                System.out.println("Kingside castling is an option!");

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                queensideCastleCheck:
                for (int i = 1; i < 3; i++) {
                    if (position[rowOfKingInQuestion][colOfKingInQuestion - i].equals("ES")) {
                        if (position[rowOfKingInQuestion][colOfKingInQuestion - i - 1].equals("ES")) {
                            if (position[rowOfKingInQuestion][colOfKingInQuestion - i - 2].equals("WR")) {
                                try (BufferedReader bufferedReader = new BufferedReader(new FileReader("res/log.txt"))) {
                                    String line;

                                    while ((line = bufferedReader.readLine()) != null) {
                                        if (line.contains("e8") || line.contains("a8")) {
                                            System.out.println("kingside castling is not an option");
                                            break queensideCastleCheck;
                                        }
                                    }

                                    System.out.println("Queenside castling is an option!");

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
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
