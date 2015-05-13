package gui;


import data.rules.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class Board {
    Color highlightLightSquare = new Color(0xffcc33);
    Color highlightDarkSquare = new Color(0xcc9933);
    Color darkSquare = new Color(0x398999);
    Color selectedPiece = new Color(0xcccccc);
    int turnDecision = 0;


    JFrame jFrame;
    JLayeredPane jLayeredPane;
    JPanel background;
    JPanel boardPlaceholder;
    JButton[][] squares;

    public void createTheBoard() {
        jFrame = new JFrame();
        jLayeredPane = new JLayeredPane();
        background = new JPanel();
        boardPlaceholder = new JPanel();
        squares = new JButton[8][8];

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(1200, 800));
        jFrame.setLayout(new BorderLayout());
        jFrame.setResizable(false);
        jFrame.setTitle("Farnsworth");

        jLayeredPane.setBounds(0, 0, 1200, 800);
        jFrame.add(jLayeredPane, BorderLayout.CENTER);

        background.setBounds(0, 0, 1200, 800);
        background.setBackground(Color.lightGray);

        boardPlaceholder.setLayout(new GridLayout(8, 8));
        boardPlaceholder.setBounds(100, 100, 512, 512);

        jLayeredPane.add(background, 0, 0);
        jLayeredPane.add(boardPlaceholder, 1, 0);

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setBorder(BorderFactory.createEmptyBorder());
                boardPlaceholder.add(squares[i][j]);

                if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
                    squares[i][j].setBackground(Color.white);
                } else {
                    squares[i][j].setBackground(darkSquare);
                }
            }
        }

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public BufferedImage iconSetter(String pieceName) {
        try {
            return ImageIO.read(new File("res/img/" + pieceName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String whichPieceIsOccupyingTheSquare(int row, int col) {
        return ((ImageIcon) squares[row][col].getIcon()).getDescription();
    }

    public void newGame(String[][] board) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                switch (board[i][j]) {
                    case "ES":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("ES"), "ES"));
                        break;

                    case "WP":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("WP"), "WP"));
                        break;

                    case "WR":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("WR"), "WR"));
                        break;

                    case "WN":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("WN"), "WN"));
                        break;

                    case "WB":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("WB"), "WB"));
                        break;

                    case "WQ":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("WQ"), "WQ"));
                        break;

                    case "WK":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("WK"), "WK"));
                        break;

                    case "BP":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("BP"), "BP"));
                        break;

                    case "BR":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("BR"), "BR"));
                        break;

                    case "BN":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("BN"), "BN"));
                        break;

                    case "BB":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("BB"), "BB"));
                        break;

                    case "BQ":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("BQ"), "BQ"));
                        break;

                    case "BK":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("BK"), "BK"));
                        break;
                }
            }
        }
    }

    public void makeButtonsInteractive() {

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                int l = i;
                int k = j;
                squares[l][k].addActionListener(e -> {
                    if ((squares[l][k].getBackground().equals(Color.white)) || (squares[l][k].getBackground().equals(darkSquare))) {
                        setSquareColorsToDefault();
                    }
                    switch (whichPieceIsOccupyingTheSquare(l, k)) {
                        case "WP":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 0) {
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(PawnRules.pawnRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "WR":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 0) {
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(RookRules.rookRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "WN":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 0) {
                                    squares[l][k].setBackground(selectedPiece);
                                }
                            break;

                        case "WB":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 0) {
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(BishopRules.bishopRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "WQ":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 0) {
                                    squares[l][k].setBackground(selectedPiece);
                                }
                            break;

                        case "WK":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 0) {
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(KingRules.kingRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "BP":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 1){
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(PawnRules.pawnRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "BR":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 1) {
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(RookRules.rookRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "BN":

                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 1) {
                                    squares[l][k].setBackground(selectedPiece);
                                }
                            break;

                        case "BB":

                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 1) {
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(BishopRules.bishopRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "BQ":

                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 1) {
                                    squares[l][k].setBackground(selectedPiece);
                                }
                            break;

                        case "BK":
                                if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                    movePiece(l, k);
                                    turnDecision++;
                                } else if ((turnDecision % 2) == 1){
                                    squares[l][k].setBackground(selectedPiece);
                                    highlightValidMoveSquares(KingRules.kingRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                }
                            break;

                        case "ES":
                            if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                movePiece(l, k);
                                turnDecision++;
                            }
                            break;

                        default:
                            System.out.println("Error");
                    }


                });
            }
        }
    }

    public boolean isPiececolorWhite(int row, int col) {
        String desc = ((ImageIcon) squares[row][col].getIcon()).getDescription();
        return desc.contains("W");
    }

    public String[][] readDescriptionOfEntireBoard() {
        String[][] boardGridWithDescriptions = new String[8][8];

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                boardGridWithDescriptions[i][j] = ((ImageIcon) squares[i][j].getIcon()).getDescription();
            }
        }

        /*for (int i = 0; i < boardGridWithDescriptions.length; i++) {
            for (int j = 0; j < boardGridWithDescriptions.length; j++) {
                System.out.print(boardGridWithDescriptions[i][j] + " ");
            }
            System.out.println();
        }*/


        return boardGridWithDescriptions;
    }

    public void highlightValidMoveSquares(String[] validMoveList) {

        for (String aValidMoveList : validMoveList) {
            System.out.println(aValidMoveList);
        }
        System.out.println("---qp---");

        for (String aValidMoveList : validMoveList) {
            int row = Integer.valueOf(aValidMoveList.substring(0, 1));
            int col = Integer.valueOf(aValidMoveList.substring(3));

            if ((squares[row][col].getBackground().equals(Color.white)) || (squares[row][col].getBackground().equals(darkSquare))) {
                if (squares[row][col].getBackground().equals(Color.white)) {
                    squares[row][col].setBackground(highlightLightSquare);
                } else {
                    squares[row][col].setBackground(highlightDarkSquare);
                }
            } else {
                if (squares[row][col].getBackground().equals(highlightDarkSquare)) {
                    squares[row][col].setBackground(darkSquare);
                } else {
                    squares[row][col].setBackground(Color.white);
                }
            }
        }
    }

    public void movePiece(int toRow, int toCol) {
        String piecename = "ES";

        LookingForSelectedPiece:
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (squares[i][j].getBackground().equals(selectedPiece)) {
                    piecename = whichPieceIsOccupyingTheSquare(i, j);
                    squares[i][j].setIcon(new ImageIcon(iconSetter("ES"), "ES"));
                    break LookingForSelectedPiece;
                }
            }
        }
        //System.out.println("PIECENAME: " + piecename);

        squares[toRow][toCol].setIcon(new ImageIcon(iconSetter(piecename), piecename));
        setSquareColorsToDefault();

    }

    public void setSquareColorsToDefault() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))) {
                    squares[i][j].setBackground(Color.white);
                } else {
                    squares[i][j].setBackground(darkSquare);
                }
            }
        }
    }
}
