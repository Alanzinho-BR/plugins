package net.eduard.chatclick;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main getPlugin() {
		return JavaPlugin.getPlugin(Main.class);
	}
	private static Main plugin;
	public static Main getInstance() {
		return plugin;
	}
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Evento(), plugin);
	}

}
