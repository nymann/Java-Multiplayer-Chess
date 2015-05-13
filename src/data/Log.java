package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class Log {

    public static void deletePreviousLog() {

        File file = new File("res/log.txt");

        if (file.delete()) {

        } else {
            System.out.println("didn't delete!");
        }

    }

    public static void addToLogFile(int moveFromRow, int moveFromCol, int moveToRow, int moveToCol) {
        File file = new File("res/log.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] algebraicNotation = {
                {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
                {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
                {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
                {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
                {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
                {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
                {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
                {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}
        };

        try {
            FileWriter fw = new FileWriter("res/log.txt", true);
            fw.write(algebraicNotation[moveFromRow][moveFromCol] + algebraicNotation[moveToRow][moveToCol] + "\r\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
