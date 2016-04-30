package me.spigot.SimPlaysGames.Register;

import me.spigot.SimPlaysGames.MaximizedClasses;
import me.spigot.SimPlaysGames.commands.ChangeClass;

public class Commands {
	
	MaximizedClasses MX;
	public Commands(MaximizedClasses MX){
		this.MX = MX;
	}
	
	public void registerCommands(){
		//Importing commands from files
		MX.getCommand("ChangeClass").setExecutor(new ChangeClass());
	}
}
