package me.spigot.SimPlaysGames;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.spigot.SimPlaysGames.Register.Commands;
import me.spigot.SimPlaysGames.Register.Config;
import me.spigot.SimPlaysGames.Register.Events;
import me.spigot.SimPlaysGames.Register.Permissions;

public final class MaximizedClasses extends JavaPlugin{
	
	public final Logger logger = getLogger();

	
	private static JavaPlugin instance;
	
	public static JavaPlugin getInstance()
	{
		return instance;
	}
	
	// Fired when plugin is first enabled
	@Override
	public void onEnable() {
		
		instance = this;
		
		// Says plugin has been enabled in cmd
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + "has been enabled! (V." + pdfFile.getVersion() + ")");
		
		Config conf = new Config(this);
		conf.registerConfig();
		
		Events event = new Events(this);
		event.registerEvents();
		
		Commands cmds = new Commands(this);
		cmds.registerCommands();
		
		Permissions perms = new Permissions(this);
		perms.registerPermissions();
		
	}
	
	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + "has been disabled! (V." + pdfFile.getVersion() + ")");
		
		Config.config = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}