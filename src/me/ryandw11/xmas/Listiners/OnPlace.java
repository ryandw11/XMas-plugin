package me.ryandw11.xmas.Listiners;

import me.ryandw11.xmas.core.Main;

import org.bukkit.ChatColor;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class OnPlace implements Listener {

	private Main plugin;
	
	public OnPlace(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		BlockState block = e.getBlockPlaced().getState();
        if (block instanceof Skull) {
            Skull skull = (Skull) block;
            String owner = skull.getOwner();
            if(owner.equals("CruXXx")){
            	e.setCancelled(true);
            	p.sendMessage(ChatColor.RED + "You may not place a present!" + ChatColor.GREEN + " You may open it with /open");
            }
        }
	}
	
}
