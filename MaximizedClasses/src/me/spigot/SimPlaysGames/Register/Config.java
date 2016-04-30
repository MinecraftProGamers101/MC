package me.spigot.SimPlaysGames.Register;

import org.bukkit.configuration.file.FileConfiguration;
import me.spigot.SimPlaysGames.MaximizedClasses;

public class Config{
	public static FileConfiguration config;
	
	public static MaximizedClasses MX;
	public Config(MaximizedClasses MX){
		Config.MX = MX;
	}
	
	
	
	public void creatingDefaultConfig(){
		config = MX.getConfig();
		config.addDefault("factionWorld", "Factions");	
		config.addDefault("ChangeClass", "MaximizedClasses.ChangeClass");	
		
		//Classes
		config.addDefault("ClassName1", "Warrior");	
		config.addDefault("ClassName2", "Assasin");	
		config.addDefault("ClassName3", "Mage");
		
		config.addDefault("ClassLore1", "Warrior");	
		config.addDefault("ClassLore2", "Assasin");	
		config.addDefault("ClassLore3", "Mage");
		
		config.addDefault("PEXclass1", "Warrior");	
		config.addDefault("PEXclass2", "Assasin");	
		config.addDefault("PEXclass3", "Mage");
		

		config.options().copyDefaults(true);
		MX.saveConfig();
	}
	
	
	public void registerConfig(){
		creatingDefaultConfig();
		
	}
}
