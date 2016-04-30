package me.spigot.SimPlaysGames.Register;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

import me.spigot.SimPlaysGames.MaximizedClasses;

public class Permissions {
	
	MaximizedClasses MX;
	public Permissions(MaximizedClasses MX){
		this.MX = MX;
	}
	
	public static String classChangeConf = Config.config.getString("ChangeClass");
	
	public void registerPermissions() {
		PluginManager pm = MX.getServer().getPluginManager();
		
		Permission classChange = new Permission(classChangeConf);

		pm.addPermission(classChange);
	}
}
