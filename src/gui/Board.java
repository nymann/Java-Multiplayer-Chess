package gui;


import data.rules.*;
import data.*;

import javax.swing.*;
import java.awt.*;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class Board {
    private final Color highlightLightSquare = new Color(0xffcc33);
    private final Color highlightDarkSquare = new Color(0xcc9933);
    private final Color darkSquare = new Color(0x398999);
    private final Color selectedPiece = new Color(0xcccccc);
    private final Color castleColorDS = new Color(0xcc9932);
    private final Color castleColorLS = new Color(0xfbc72c);
    private final Color enPassantColorLS = new Color(0xffcc35);
    private final Color getEnPassantColorDS = new Color(0xc99836);

    private int turnDecision = 0;


    private JButton[][] squares;

    public void createTheBoard() {
        JFrame jFrame = new JFrame();
        JLayeredPane jLayeredPane = new JLayeredPane();
        JPanel background = new JPanel();
        JPanel boardPlaceholder = new JPanel();
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

    private ImageIcon iconSetter(String pieceName) {
        return new ImageIcon(getClass().getResource("res/img/" + pieceName + ".png"), pieceName);
    }

    private String whichPieceIsOccupyingTheSquare(int row, int col) {
        return ((ImageIcon) squares[row][col].getIcon()).getDescription();
    }

    public void newGame(String[][] board) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                switch (board[i][j]) {
                    case "ES":
                        squares[i][j].setIcon(iconSetter("ES"));
                        break;

                    case "WP":
                        squares[i][j].setIcon(iconSetter("WP"));
                        break;

                    case "WR":
                        squares[i][j].setIcon(iconSetter("WR"));
                        break;

                    case "WN":
                        squares[i][j].setIcon(iconSetter("WN"));
                        break;

                    case "WB":
                        squares[i][j].setIcon(iconSetter("WB"));
                        break;

                    case "WQ":
                        squares[i][j].setIcon(iconSetter("WQ"));
                        break;

                    case "WK":
                        squares[i][j].setIcon(iconSetter("WK"));
                        break;

                    case "BP":
                        squares[i][j].setIcon(iconSetter("BP"));
                        break;

                    case "BR":
                        squares[i][j].setIcon(iconSetter("BR"));
                        break;

                    case "BN":
                        squares[i][j].setIcon(iconSetter("BN"));
                        break;

                    case "BB":
                        squares[i][j].setIcon(iconSetter("BB"));
                        break;

                    case "BQ":
                        squares[i][j].setIcon(iconSetter("BQ"));
                        break;

                    case "BK":
                        squares[i][j].setIcon(iconSetter("BK"));
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
                                highlightValidMoveSquares(KnightRules.knightRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
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
                                highlightValidMoveSquares(BishopRules.bishopRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                highlightValidMoveSquares(RookRules.rookRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
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
                            } else if ((turnDecision % 2) == 1) {
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
                                highlightValidMoveSquares(KnightRules.knightRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
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
                                highlightValidMoveSquares(BishopRules.bishopRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                                highlightValidMoveSquares(RookRules.rookRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                            }
                            break;

                        case "BK":
                            if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                movePiece(l, k);
                                turnDecision++;
                            } else if ((turnDecision % 2) == 1) {
                                squares[l][k].setBackground(selectedPiece);
                                highlightValidMoveSquares(KingRules.kingRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k)));
                            }
                            break;

                        case "ES":
                            if ((squares[l][k].getBackground().equals(highlightDarkSquare)) || (squares[l][k].getBackground().equals(highlightLightSquare))) {
                                movePiece(l, k);
                                turnDecision++;
                            }
                            else if ((squares[l][k].getBackground().equals(castleColorDS)) || (squares[l][k].getBackground().equals(castleColorLS))) {
                                letsCastle(l, k);
                                turnDecision++;
                            }
                            else if ((squares[l][k].getBackground().equals(getEnPassantColorDS)) || (squares[l][k].getBackground().equals(enPassantColorLS))) {
                                letsEnPassant(l, k);
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

    private boolean isPiececolorWhite(int row, int col) {
        String desc = ((ImageIcon) squares[row][col].getIcon()).getDescription();
        return desc.contains("W");
    }

    private String[][] readDescriptionOfEntireBoard() {
        String[][] boardGridWithDescriptions = new String[8][8];

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                boardGridWithDescriptions[i][j] = ((ImageIcon) squares[i][j].getIcon()).getDescription();
            }
        }

        return boardGridWithDescriptions;
    }

    private void highlightValidMoveSquares(String[] validMoveList) {

        for (String aValidMoveList : validMoveList) {
            if ((aValidMoveList.substring(0, 1).equals("W") || aValidMoveList.substring(0, 1).equals("B"))) {
                if (aValidMoveList.substring(0, 1).equals("W")) {
                    if (aValidMoveList.equals("WKC")) {
                        //System.out.println("White King side castle.");
                        squares[7][6].setBackground(castleColorDS);
                    }

                    if (aValidMoveList.equals("WQC")) {
                        //System.out.println("White Queen side castle.");
                        squares[7][2].setBackground(castleColorDS);
                    }
                } else {
                    if (aValidMoveList.equals("BKC")) {
                        //System.out.println("White King side castle.");
                        squares[0][6].setBackground(castleColorLS);
                    }

                    if (aValidMoveList.equals("BQC")) {
                        //System.out.println("White Queen side castle.");
                        squares[0][2].setBackground(castleColorLS);
                    }
                }


            }

            else if (aValidMoveList.substring(0, 1).equals("E")) {
                System.out.println(aValidMoveList);

                int row = Integer.valueOf(aValidMoveList.substring(1, 2));
                int col = Integer.valueOf(aValidMoveList.substring(4));

                if (squares[row][col].getBackground().equals(Color.white)) {
                    squares[row][col].setBackground(enPassantColorLS);
                }
                else {
                    squares[row][col].setBackground(getEnPassantColorDS);
                }

            }

            else {
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
    }

    private void movePiece(int toRow, int toCol) {
        String piecename = "ES";

        LookingForSelectedPiece:
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (squares[i][j].getBackground().equals(selectedPiece)) {
                    piecename = whichPieceIsOccupyingTheSquare(i, j);
                    Log.addToLogFile(i, j, toRow, toCol);
                    squares[i][j].setIcon(iconSetter("ES"));

                    break LookingForSelectedPiece;
                }
            }
        }

        squares[toRow][toCol].setIcon(iconSetter(piecename));
        setSquareColorsToDefault();
        checkForPromotion(readDescriptionOfEntireBoard());

    }

    private void setSquareColorsToDefault() {
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

    private void checkForPromotion(String[][] position) {
        for (int i = 0; i < position.length; i++) {
            if (position[0][i].equals("WP")) {
                squares[0][i].setIcon(iconSetter("WQ"));
            } else if (position[7][i].equals("BP")) {
                squares[7][i].setIcon(iconSetter("BQ"));
            }
        }

    }

    private void letsCastle(int row, int col) {
        if (row == 0) {
            // Black castle
            if (col == 2) {
                // Queen side
                squares[0][0].setIcon(iconSetter("ES"));
                squares[0][3].setIcon(iconSetter("BR"));
                squares[0][2].setIcon(iconSetter("BK"));
                squares[0][4].setIcon(iconSetter("ES"));
                Log.castleToLogFile("0-0-0");
            }

            else {
                // King side
                squares[0][7].setIcon(iconSetter("ES"));
                squares[0][4].setIcon(iconSetter("ES"));
                squares[0][5].setIcon(iconSetter("BR"));
                squares[0][6].setIcon(iconSetter("BK"));
                Log.castleToLogFile("0-0");
            }
        }

        else {
            // White castle
            if (col == 2) {
                // Queen side
                squares[7][0].setIcon(iconSetter("ES"));
                squares[7][3].setIcon(iconSetter("WR"));
                squares[7][2].setIcon(iconSetter("WK"));
                squares[7][4].setIcon(iconSetter("ES"));
                Log.castleToLogFile("0-0-0");
            }

            else {
                // King side
                squares[7][7].setIcon(iconSetter("ES"));
                squares[7][4].setIcon(iconSetter("ES"));
                squares[7][5].setIcon(iconSetter("WR"));
                squares[7][6].setIcon(iconSetter("WK"));
                Log.castleToLogFile("0-0");
            }
        }
        setSquareColorsToDefault();
    }

    private void letsEnPassant(int row, int col) {
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

        if (row == 2) {
            // It's white who is trying to en passant.
            squares[row][col].setIcon(iconSetter("WP"));
            squares[findRowOfSelectedPiece()][findColOfSelectedPiece()].setIcon(iconSetter("ES"));
            squares[findRowOfSelectedPiece()][col].setIcon(iconSetter("ES"));
        }
        else {
            // It's black who is trying to en passant.
            squares[row][col].setIcon(iconSetter("BP"));
            squares[findRowOfSelectedPiece()][findColOfSelectedPiece()].setIcon(iconSetter("ES"));
            squares[findRowOfSelectedPiece()][col].setIcon(iconSetter("ES"));
        }

        String move = an[findRowOfSelectedPiece()][findColOfSelectedPiece()] + "x" + an[row][col];
        Log.enPassantToLogFile(move);
        setSquareColorsToDefault();
    }

    private int findColOfSelectedPiece() {
        for (JButton[] square : squares) {
            for (int j = 0; j < squares.length; j++) {
                if (square[j].getBackground().equals(selectedPiece)) {
                    return j;
                }
            }
        }

        return -1;
    }

    private int findRowOfSelectedPiece() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (squares[i][j].getBackground().equals(selectedPiece)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
