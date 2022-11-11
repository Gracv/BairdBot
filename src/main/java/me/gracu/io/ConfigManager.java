package me.gracu.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private String fileName = "config.yml";
    private File file = new File(fileName);
    private boolean fileExists = file.exists();

    public void fileManager() {
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                writer.write("token: xyz");
                writer.close();
            } catch (IOException e) {
                System.out.println("Failed to create a file");
            }
        }
    }
}
