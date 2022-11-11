package me.gracu.io;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigHandler {

    public static final Path configPath = Paths.get("./config.yml");
    private static ConfigHandler configHandler;
    Config config;

    public static ConfigHandler getInstance() throws FileNotFoundException {
        return getInstance(configPath);
    }

    public static ConfigHandler getInstance(Path configPath) throws FileNotFoundException {
        if (configHandler == null) {
            configHandler = new ConfigHandler(configPath);
        }
        return configHandler;
    }

    private ConfigHandler(Path configPath) throws FileNotFoundException {
        this.config = loadConfig(configPath);
    }

    public Config loadConfig(Path configPath) throws FileNotFoundException {
        Constructor constructor = new Constructor(Config.class);
        Yaml yaml = new Yaml(constructor);
        return yaml.load(new FileInputStream(configPath.toFile()));
    }

    public void dumpConfig() throws IllegalArgumentException, IOException {
        dumpConfig(this.config, this.configPath);
    }

    public void dumpConfig(Config config, Path configPath) throws IllegalArgumentException, IOException {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        Yaml yml = new Yaml(options);
        yml.dump(config, new FileWriter(configPath.toFile()));
    }

    public Config getConfig() {
        return this.config;
    }
}
