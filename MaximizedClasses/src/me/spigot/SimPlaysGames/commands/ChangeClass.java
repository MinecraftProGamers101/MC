package me.spigot.SimPlaysGames.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spigot.SimPlaysGames.MaximizedClasses;
import me.spigot.SimPlaysGames.InformationStorage.PlayerCheck;
import me.spigot.SimPlaysGames.Methods.Menu;
import me.spigot.SimPlaysGames.Register.Config;
import me.spigot.SimPlaysGames.Register.UserDataConfig;

public class ChangeClass implements CommandExecutor {

	UserDataConfig userData = new UserDataConfig(MaximizedClasses.getInstance(), "UserData.yml"); 
	FileConfiguration userDataConfig = userData.getConfig(); 
	public static String classChangeConf = Config.config.getString("ChangeClass");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) 
	{
		if (sender instanceof Player) 
		{
			Player player = (Player) sender; // Defines player as sender
			if (player.hasPermission(classChangeConf)) 
			{	
				// Checks if the user is in the VIP list
				if (userDataConfig.getStringList("VIP").contains(player.getUniqueId().toString())) 
				{
					player.sendMessage(ChatColor.RED + "You have already chosen a class");
					return true;
				} 
				else 
				{
					PlayerCheck.set(player, false);
					Menu.menuMethod(player);
					return true;
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "You do not have permission to do this command");
				return true;
			}
		} 
		else 
		{
			sender.sendMessage("You have to be a player to do this command");
			return true;
		}

	}

}
