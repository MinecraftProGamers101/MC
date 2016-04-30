package me.spigot.SimPlaysGames.Methods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spigot.SimPlaysGames.MaximizedClasses;
import me.spigot.SimPlaysGames.Register.UserDataConfig;

public class SetUUID {
	
	//Global uuid Set instead of single class : for outside class usage
	public static Set<UUID> uuids = new HashSet<>();
	
    public static void setUUID(Player player, String group) {
    	int i = 0; //this int if for the VIP people, who get to choose their class once more
        UserDataConfig userData = new UserDataConfig(MaximizedClasses.getInstance(), "UserData.yml"); // get the config test.yml, if it isn't exists it will be created
        FileConfiguration userDataConfig = userData.getConfig(); // get its config instance.
        String playerUUID = player.getUniqueId().toString(); //Makes the UUID a string        
    		if (group.equals("VIP")) { //checks if the person is VIP
    			if (i == 0) { //if the player has not choosen a kit AND is a VIP
    			    	i++; //changes the int to 1, because they have equipted the class and are VIP
    				userDataConfig.set(group, list);
        			userData.saveConfig(); // save it	
    			} else { //if the player has already choosen a kit, add them to the uuid so they cant get another one.
        			uuids.add(player.getUniqueId()); 
    			}
    		}
    }
	
}
