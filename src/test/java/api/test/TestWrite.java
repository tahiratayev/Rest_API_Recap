package api.test;

import java.io.File;
import java.io.IOException;

public class TestWrite {
    public static void main(String[] args) {
        try {
            File myFile = new File("/api/test/testfile.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}