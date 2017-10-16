
package net.eduard.template;

import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.EduardPlugin;
import net.eduard.template.command.TemplateCommand;

public class Main extends EduardPlugin {
	private static Main plugin;
	public static Main getInstance() {
		return plugin;
	}
	public static Main getPlugin() {
		return JavaPlugin.getPlugin(Main.class);
	}
	@Override
	public void onEnable() {
		plugin = this;
		new TemplateCommand().register();
	}

	@Override
	public void onDisable() {
	}

}
