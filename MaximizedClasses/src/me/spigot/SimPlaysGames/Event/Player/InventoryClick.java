package me.spigot.SimPlaysGames.Event.Player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.spigot.SimPlaysGames.InformationStorage.PlayerCheck;
import me.spigot.SimPlaysGames.Methods.Menu;
import me.spigot.SimPlaysGames.Methods.SetUUID;
import me.spigot.SimPlaysGames.Register.Config;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class InventoryClick implements Listener {

	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		String PEXClass1 = Config.config.getString("PEXclass1");
		String PEXClass2 = Config.config.getString("PEXclass2");
		String PEXClass3 = Config.config.getString("PEXclass3");
		
		Inventory inv = event.getInventory();
		
		//Checks if the title is not equal to Custom Inventory
		if(!(inv.getTitle().equals("Class Menu"))){
			return;
		}
		
		//Checks if it's something else then a player who clicked
		if(!(event.getWhoClicked() instanceof Player)){
			return;
		}
		
		
		Player player = (Player) event.getWhoClicked(); //player = who ever clicked
		ItemStack item = event.getCurrentItem();		//gets what item you clicked on
		
		//Group
		String group;
		
		if(PlayerCheck.get(player) == true)
		{
			group = "Members";
		} 
		else 
		{
			group = "VIP";
		}
		
		//Item 1
		if(item.getItemMeta().getDisplayName().equals(Menu.className1)){			//If the item is a compass do
			PermissionUser permissionUser = PermissionsEx.getUser(player);
			permissionUser.removeGroup(PEXClass3);
			permissionUser.removeGroup(PEXClass2);
			permissionUser.addGroup(PEXClass1);
			player.sendMessage("You chose to be the " + ChatColor.GOLD + Menu.className1 + ChatColor.RESET + " class" );
			
			event.setCancelled(true);					//Makes so the taking event is cancelled
			player.closeInventory();					//Closes the players inventory
			
			SetUUID.setUUID(player, group);					//Adds UUID to list
		}
		//Item 2
		else if(item.getItemMeta().getDisplayName().equals(Menu.className2)){			//If the item is a compass do
			PermissionUser permissionUser = PermissionsEx.getUser(player);
			permissionUser.removeGroup(PEXClass1);
			permissionUser.removeGroup(PEXClass3);
			permissionUser.addGroup(PEXClass2);
			player.sendMessage("You chose to be the " + ChatColor.GOLD + Menu.className2 + ChatColor.RESET + " class" );
			
			event.setCancelled(true);					//Makes so the taking event is cancelled
			player.closeInventory();					//Closes the players inventory
			
			SetUUID.setUUID(player, group);					//Adds UUID to list
		}
		//Item 3
		else if(item.getItemMeta().getDisplayName().equals(Menu.className3)){			//If the item is a compass do
			PermissionUser permissionUser = PermissionsEx.getUser(player);
			permissionUser.removeGroup(PEXClass1);
			permissionUser.removeGroup(PEXClass2);
			permissionUser.addGroup(PEXClass3);
			player.sendMessage("You chose to be the " + ChatColor.GOLD + Menu.className3 + ChatColor.RESET + " class" );
			
			event.setCancelled(true);					//Makes so the taking event is cancelled
			player.closeInventory();					//Closes the players inventory
			
			SetUUID.setUUID(player, group);					//Adds UUID to list
		}
		
		
		event.setCancelled(true);
		player.closeInventory();
		
	}
	
	
}
