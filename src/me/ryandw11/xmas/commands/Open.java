package me.ryandw11.xmas.commands;

import java.util.List;

import me.ryandw11.xmas.core.Main;


import net.minecraft.server.v1_8_R3.Material;

import org.bukkit.ChatColor;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Open implements CommandExecutor {
	
	
	private Main plugin;
	
	public Open(Main plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("Open")){
			if(!(p instanceof Player )) return true;
			ItemStack hand = p.getItemInHand();
			if(hand.getType().name().equals("SKULL_ITEM")){
				SkullMeta sm = (SkullMeta) hand.getItemMeta();
	            if(sm.hasOwner()){
	            	if(sm.getOwner().equals("CruXXx")){
	            		String lore = hand.getItemMeta().getLore().get(0);
	            		Material mat = Material.valueOf(ChatColor.stripColor(lore));
	            		p.getInventory().addItem(new ItemStack(mat));
	            		
	            	}
	            }
	            	
			}
		}
		
		return false;
	}

}
