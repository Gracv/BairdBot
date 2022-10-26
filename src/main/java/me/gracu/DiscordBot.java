package me.gracu;

import me.gracu.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.*;
import java.util.Scanner;

public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "token.txt";
        File file = new File(fileName);
        String token = null;

        boolean fileExists = file.exists();
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

        JDA bot = JDABuilder.createDefault(token)
                .setActivity(Activity.playing("with your mom"))
                .addEventListeners(new MessageListener())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }
}
