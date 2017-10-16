package net.eduard.template.bungee;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin implements Listener {
	@Override
	public void onEnable() {
		plugin = this;
		BungeeCord.getInstance().getPluginManager().registerListener(this,
				new TemplateEvents());

		BungeeCord.getInstance().getPluginManager().registerCommand(this,
				new TemplateCommand());
		BungeeCord.getInstance().getConsole()
				.sendMessage(new TextComponent("Plugin ativado"));
	}
	private static Main plugin;
	public static Main getPlugin() {
		return plugin;
	}
}
