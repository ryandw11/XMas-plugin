package me.ryandw11.xmas.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;





import me.ryandw11.xmas.Listiners.OnPlace;
import me.ryandw11.xmas.commands.Gift;



import me.ryandw11.xmas.commands.Open;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public Main plugin;
	
	//public File playerfile = new File(getDataFolder() + "/playerdata.yml");
	//public FileConfiguration player = YamlConfiguration.loadConfiguration(playerfile);
	//
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("Holly is enabled and running fine! V: 1.0"); // prints into the log
		loadMethoid();
//		loadFile();
		//registerConfig();
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("Holly has been disabled correctly!"); // same thing
//		saveFile();
	}
	
	
	
	
	
	
	
//	private void registerConfig() {
//		getConfig().options().copyDefaults(true);
//		saveConfig();
//	}
	
	
	
	
	
	
	
	
//	public void saveFile(){
//		
//		try{
//			player.save(playerfile);
//		}catch(IOException e){
//			e.printStackTrace();
//			
//		}
//		
//	}
//	
//	public void loadFile(){
//		if(playerfile.exists()){
//			try {
//				player.load(playerfile);
//			} catch (IOException | InvalidConfigurationException e) {
//
//				e.printStackTrace();
//			}
//		}
//		else{
//			try {
//				player.save(playerfile);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public void loadMethoid(){
		getCommand("Open").setExecutor(new Open(this));
		getCommand("gift").setExecutor(new Gift(this));
		
		Bukkit.getServer().getPluginManager().registerEvents(new OnPlace(this), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new Join(this), this);
		
		//Bukkit.getServer().getPluginManager().registerEvents(new Sound(this), this);
	//	Bukkit.getServer().getPluginManager().registerEvents(new ChestClick(this), this);
		
		
	}

}