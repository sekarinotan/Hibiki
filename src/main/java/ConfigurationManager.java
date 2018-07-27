
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adminpc
 */
public class ConfigurationManager {

    private static ConfigurationManager instance;
    private Configuration configuration;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Path configFile = new File(".").toPath().resolve("config.json");

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public ConfigurationManager() {
        if (!configFile.toFile().exists()) {
            System.out.println("Configuration: config.json was not found");
            System.exit(util.ErrorMessage.NO_CONFIG_FILE);
        }
        loadConfig();
    }

    public void loadConfig() {
        try {
            BufferedReader reader = Files.newBufferedReader(configFile);
            this.configuration = gson.fromJson(reader, Configuration.class);
            reader.close();
            System.out.println("Configuration: config.json loaded");
        } catch (IOException ex) {
            System.out.println("Configuration: Error loading config.json");
            ex.printStackTrace();
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
