package me.gracu.io;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Config {
    String fileName = "token.txt";
    File file = new File(fileName);
    public String token = null;

    boolean fileExists = file.exists();

    public void fileManager() throws FileNotFoundException {
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku");
            }
        } else {
            Scanner scan = new Scanner(file);
            System.out.println("Plik " + fileName + " istnieje lub został utworzony");
            token = scan.nextLine();
            scan.close();
        }
    }
//    Yaml yaml = new Yaml();
}
