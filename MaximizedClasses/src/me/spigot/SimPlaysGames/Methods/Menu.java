package me.spigot.SimPlaysGames.Methods;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.spigot.SimPlaysGames.Register.Config;

public class Menu {
	
	public static String className1 = Config.config.getString("ClassName1");
	public static String className2 = Config.config.getString("ClassName2");
	public static String className3 = Config.config.getString("ClassName3");
	
	public static String class1Name = className1;
	public static String class2Name = className2;
	public static String class3Name = className3;
	
	public static List<String> classLore1 = Config.config.getStringList("classLore1");
	public static List<String> classLore2 = Config.config.getStringList("classLore2");
	public static List<String> classLore3 = Config.config.getStringList("classLore3");
	
	
	@SuppressWarnings("deprecation")
	public static void menuMethod(Player player) {
		
			
		Inventory inv = Bukkit.createInventory(null, 9, "Class Menu");

		ItemStack class1ItemTemp = new ItemStack(Material.STAINED_CLAY, 1, (byte)DyeColor.BLUE.getData());
		ItemStack class2ItemTemp = new ItemStack(Material.STAINED_CLAY, 1, (byte)DyeColor.RED.getData());
		ItemStack class3ItemTemp = new ItemStack(Material.STAINED_CLAY, 1, (byte)DyeColor.GREEN.getData());
		
		ItemStack class1Name = nameItem(class1ItemTemp,className1, classLore1);
		ItemStack class2Name = nameItem(class2ItemTemp, className2, classLore2);
		ItemStack class3Name = nameItem(class3ItemTemp, className3, classLore3);
			
		inv.setItem(3, class1Name); //4 = mid
		inv.setItem(4, class2Name); //4 = mid
		inv.setItem(5, class3Name); //4 = mid

		player.openInventory(inv);
	}

	private static ItemStack nameItem(ItemStack item, String name, List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		
		meta.setLore(lore);
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		

		return item;
	}

	@SuppressWarnings("unused")
	private static ItemStack nameItem(Material item, String name, List<String> lore) {

		return nameItem(new ItemStack(item), name, lore);
	}
}
