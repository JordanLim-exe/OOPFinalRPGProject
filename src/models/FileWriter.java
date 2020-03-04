package models;

import java.io.IOException;

public class FileWriter {
    public void write(String string, String fileName) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("savestate/" + fileName + ".txt", true);
            writer.write(string);
            writer.close();
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
