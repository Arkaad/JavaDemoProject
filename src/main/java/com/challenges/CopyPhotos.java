package com.challenges;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyPhotos {

    private static final String glossaryFilePath = "/Users/arkadutta/dropbox/Miscellaneous/pic-glossary.txt";
    private static final String sourcePath = "/Users/arkadutta/Desktop/Pics/";
    private static final String Destination = "/Users/arkadutta/Desktop/Final-Pics/";

    public static void main(String[] args) {
        Scanner myReader = null;
        int copyCount = 0;
        String src = "";
        try {
            Files.createDirectories(Paths.get(Destination));
            FileUtils.cleanDirectory(new File(Destination));

            myReader = new Scanner(new File(glossaryFilePath));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (data.contains("/")) {
                    src = sourcePath + data + "/";
                    continue;
                }
                Files.copy(Paths.get(src + data), Paths.get(Destination + data));
                copyCount++;
            }
            System.out.println("Copied " + copyCount + " images.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (myReader != null) {
                myReader.close();
            }
        }
    }
}
