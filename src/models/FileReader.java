package models;

import java.io.IOException;

public class FileReader {

    public String read(String input) {
        StringBuilder sb = new StringBuilder();

        try {
            java.io.FileReader reader = new java.io.FileReader(input + ".txt");
            int character;

            while((character = reader.read()) != -1) {
                sb.append((char) character);
            }
            reader.close();
        }catch(IOException ioe) {
            System.out.println("File does not exist.");
        }
        return sb.toString();
    }

}
