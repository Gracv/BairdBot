package me.gracu;

import me.gracu.io.Config;
import me.gracu.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.*;

public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws FileNotFoundException {

        Config config = new Config();
        config.fileManager();

        JDA bot = JDABuilder.createDefault(config.token)
                .setActivity(Activity.playing("with your mom"))
                .addEventListeners(new MessageListener())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }
}
