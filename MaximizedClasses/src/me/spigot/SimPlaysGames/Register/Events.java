package me.spigot.SimPlaysGames.Register;

import org.bukkit.plugin.PluginManager;

import me.spigot.SimPlaysGames.MaximizedClasses;
import me.spigot.SimPlaysGames.Event.Player.ChangeWorld;
import me.spigot.SimPlaysGames.Event.Player.InventoryClick;

public class Events {
	
	
	
	MaximizedClasses MX;
	public Events(MaximizedClasses MX){
		this.MX = MX;
	}
	
	public void registerEvents(){
		PluginManager pm = MX.getServer().getPluginManager();
		
		
		//Block Events
		//pm.registerEvents(new BlockBreak(),this);
		
		//Player events
		pm.registerEvents(new ChangeWorld(),(MaximizedClasses.getInstance()));
		pm.registerEvents(new InventoryClick(),(MaximizedClasses.getInstance()));
	}
}
