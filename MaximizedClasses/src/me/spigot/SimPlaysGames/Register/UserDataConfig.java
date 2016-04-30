package me.spigot.SimPlaysGames.Register;

import java.io.File;
import java.io.IOException;
 
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
 
public final class UserDataConfig
{
    private final File dataFile; // the real file that stores your config
    private FileConfiguration data; // bukkit config instance
 
    public UserDataConfig(final JavaPlugin plugin, final String configName) 
    {
        this.dataFile = new File(plugin.getDataFolder(), configName);  // it creates new file instance with given file name in the plugin directory (plugins/<PluginName>/)
 
        // next it creates the file if it isn't exists
        if (!this.dataFile.exists())
        {
            try
            {
                this.dataFile.createNewFile();
            }
            catch (final IOException e)
            {
                throw new RuntimeException("An exception occured while creating config file", e);
            }
        }
        this.reloadConfig();
    }
 
    // this method reloads changes from file, like bukkit .reloadConfig() with standard config
    public void reloadConfig()
    {
        this.data = YamlConfiguration.loadConfiguration(this.dataFile);
    }
 
    // this method save changes to file, like bukkit .saveConfig()
    public void saveConfig() 
    {
        try
        {
            this.data.save(this.dataFile);
        }
        catch (IOException e)
        {
            throw new RuntimeException("An exception occured while saving storage file", e);
        }
    }
    
    // returns bukkit config instance
    public FileConfiguration getConfig()
    {
        return data;
    }
}

/*
 
// example usage
UserDataConfig myconfig = new UserDataConfig(MyPlugin.getInstance(), "test.yml"); // get the config test.yml, if it isn't exists it will be created
FileConfiguration config = myconfig.getConfig(); // get its config instance
 
// add some values
config.set("test", "something");
config.set("user.points", 20);
myconfig.saveConfig(); // save it
*/