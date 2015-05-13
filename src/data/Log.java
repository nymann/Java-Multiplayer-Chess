package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * By Kristian, you can find me on Github at Github.com/Nymann.
 */
public class Log {

    public static void addToLogFile(boolean white, String moveFrom, String moveTo, int moveNumber) {
        File file = new File("res/log.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter("res/log.txt", true);
            if (white) {
                fw.write(moveNumber + ". " + moveFrom + "-" + moveTo);
                fw.close();
            }
            else {
                fw.write("     " + moveFrom + "-" + moveTo + "\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
