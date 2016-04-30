package me.spigot.SimPlaysGames.InformationStorage;

import java.util.Map;
import java.util.WeakHashMap;

import org.bukkit.entity.Player;

public class PlayerCheck
{
    private static final Map<Player, Boolean> map = new WeakHashMap<>();
 
    public static void set(Player player, boolean value)
    {
        map.put(player, value);
    }
   
    public static boolean get(Player player)
    {
        return map.get(player);
    }
}
