package me.spigot.SimPlaysGames.Methods;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.spigot.SimPlaysGames.MaximizedClasses;
import me.spigot.SimPlaysGames.Register.UserDataConfig;

public class SetUUID {
	
    public static void setUUID(Player player, String group) {
        UserDataConfig userData = new UserDataConfig(MaximizedClasses.getInstance(), "UserData.yml"); // get the config test.yml, if it isn't exists it will be created
        FileConfiguration userDataConfig = userData.getConfig(); // get its config instance
       
        //Adds one players UUID to list Members
        List<String> list = userDataConfig.contains(group) ? userDataConfig.getStringList(group) : new ArrayList<>();
        String playerUUID = player.getUniqueId().toString(); //Makes the UUID a string
       
        list.add(playerUUID);
        userDataConfig.set(group, list);
        userData.saveConfig(); // save it
    }
	
}
