package me.spigot.SimPlaysGames.Event.Player;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import me.spigot.SimPlaysGames.MaximizedClasses;
import me.spigot.SimPlaysGames.InformationStorage.PlayerCheck;
import me.spigot.SimPlaysGames.Methods.Menu;
import me.spigot.SimPlaysGames.Register.Config;
import me.spigot.SimPlaysGames.Register.UserDataConfig;



public class ChangeWorld implements Listener{
	
	UserDataConfig userData = new UserDataConfig(MaximizedClasses.getInstance(), "UserData.yml"); // get the config test.yml, if it isn't exists it will be created
	FileConfiguration userDataConfig = userData.getConfig(); // get its config instance
	
	@EventHandler
	public void ChangeWorldEvent(PlayerChangedWorldEvent event) {
		
		String factionWorld = Config.config.getString("factionWorld");
		
		Player player = (Player) event.getPlayer();
		World world = player.getWorld();
		if(!(world.getName().equalsIgnoreCase(factionWorld)))
		{
			return;
		}
		
		else 
		{
			if(userDataConfig.getStringList("Members").contains(player.getUniqueId().toString())){
				return;
			}
			else{
				PlayerCheck.set(player, true);
				Menu.menuMethod(player);
			}
		}
		
	}
}
