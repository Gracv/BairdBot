package me.gracu;

import me.gracu.io.Config;
import me.gracu.io.ConfigHandler;
import me.gracu.io.ConfigManager;
import me.gracu.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.*;

public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws IllegalArgumentException, IOException, SecurityException {

        ConfigManager manager = new ConfigManager();
        manager.fileManager();
        ConfigHandler handler = ConfigHandler.getInstance();
        Config config = handler.getConfig();

        JDA bot = JDABuilder.createDefault(config.getToken())
                .setActivity(Activity.playing(":)"))
                .addEventListeners(new MessageListener())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
    }
}
