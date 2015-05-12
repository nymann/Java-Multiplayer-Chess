package gui;

import data.Rules;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by NEX on 12/05/2015.
 */
public class Board {
    int[] moveTo;
    int[] moveFrom;


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

                if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && (j % 2 == 1))){
                    squares[i][j].setBackground(Color.white);
                }

                else {
                    squares[i][j].setBackground(new Color(0x398999));
                }
            }
        }

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public BufferedImage iconSetter(String pieceName) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File("res/img/" + pieceName + ".png"));
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isSquareEmpty(int row, int col) {
        String desc = ((ImageIcon) squares[row][col].getIcon()).getDescription();
        if(desc.equals("ES")) {
            return true;
        }

        else {
            return false;
        }
    }

    public String whichPieceIsOccupyingTheSquare(int row, int col) {
        String desc = ((ImageIcon) squares[row][col].getIcon()).getDescription();
        return desc;
    }

    public void newGame(String[][] board) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                switch (board[i][j]) {
                    case "ES":
                        squares[i][j].setIcon(new ImageIcon(iconSetter("Blank"), "ES"));
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

    public void updateSquare(int rowFrom, int colFrom, int rowTo, int colTo, String pieceName) {
        squares[rowFrom][colFrom].setIcon(new ImageIcon(iconSetter("Blank"), "ES"));
        squares[rowTo][colTo].setIcon(new ImageIcon(iconSetter(pieceName), pieceName));
    }

    public void makeButtonsInteractive() {

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                int l = i;
                int k = j;
                squares[i][j].addActionListener(e -> {
                    if (isSquareEmpty(l, k)) {
                        // Do nothing.
                    }
                    else {
                        switch (whichPieceIsOccupyingTheSquare(l, k)) {
                            case "WP":
                                Rules.pawnRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k));
                                break;

                            case "WR":
                                System.out.println("White rook");
                                break;

                            case "WN":
                                System.out.println("White knight");
                                break;

                            case "WB":
                                System.out.println("White bishop");
                                break;

                            case "WQ":
                                System.out.println("White queen");
                                break;

                            case "WK":
                                System.out.println("White king");
                                break;

                            case "BP":
                                Rules.pawnRule(readDescriptionOfEntireBoard(), l, k, isPiececolorWhite(l, k));
                                break;

                            case "BR":
                                System.out.println("Black rook");
                                break;

                            case "BN":
                                System.out.println("Black knight");
                                break;

                            case "BB":
                                System.out.println("Black bishop");
                                break;

                            case "BQ":
                                System.out.println("Black queen");
                                break;

                            case "BK":
                                System.out.println("Black king");
                                break;
                        }


                    }
                });
            }
        }
    }

    public boolean isPiececolorWhite(int row, int col) {
        String desc = ((ImageIcon) squares[row][col].getIcon()).getDescription();

        if (desc.contains("W")) {
            System.out.println("The clicked piece is white.");
            return true;
        }

        else {
            System.out.println("The clicked piece is black.");
            return false;
        }
    }

    public String[][] readDescriptionOfEntireBoard() {
        String[][] boardGridWithDescriptions = new String[8][8];

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                boardGridWithDescriptions[i][j] = ((ImageIcon) squares[i][j].getIcon()).getDescription();
            }
        }

        for (int i = 0; i < boardGridWithDescriptions.length; i++) {
            for (int j = 0; j < boardGridWithDescriptions.length; j++) {
                System.out.print(boardGridWithDescriptions[i][j] + " ");
            }
            System.out.println();
        }
        
        

        return boardGridWithDescriptions;
    }
}
