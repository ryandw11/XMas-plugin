package me.ryandw11.xmas.commands;

import java.util.ArrayList;
import java.util.List;

import me.ryandw11.xmas.core.Main;
import net.minecraft.server.v1_8_R3.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Gift implements CommandExecutor {
private Main plugin;
	
	public Gift(Main plugin){
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("Gift")){
			if(!(p instanceof Player )) return true;
			if(args.length != 0){
				p.sendMessage("Invalid use: /gift");
				
			}
			else if(args.length == 0){
				if(p.hasPermission("holly.gift")){
				
					ItemStack item = p.getItemInHand();
					p.getInventory().removeItem(p.getItemInHand());
					
				//========================
					List<String> lores = new ArrayList<String>();
					lores.add(ChatColor.MAGIC +item.getType().name().toString());
					//=====
					ItemStack Preseant = new ItemStack(397, 1, (short) 3);
					SkullMeta PreseantMeta = (SkullMeta) Preseant.getItemMeta();
					PreseantMeta.setOwner("CruXXx");
					PreseantMeta.setDisplayName(ChatColor.GREEN + "Preseant");
					PreseantMeta.setLore(lores);
					Preseant.setItemMeta(PreseantMeta);
					p.getInventory().addItem(Preseant);
					p.sendMessage(ChatColor.GREEN + "The gift!!" + item.getType().name().toString());
					
				}
			}
			
			
		}
		
		return false;
	}

}
