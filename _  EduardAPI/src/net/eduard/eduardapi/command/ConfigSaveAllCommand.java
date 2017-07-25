
package net.eduard.eduardapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.eduard.api.config.ConfigSection;
import net.eduard.api.config.Config;
import net.eduard.api.manager.CMD;

public class ConfigSaveAllCommand extends CMD {

	public ConfigSaveAllCommand() {
		super("all","todas");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Config.reloadConfigs();
		ConfigSection.chat(sender,
				"�aTodas configura��es de todos plugins foram salvadas!");
		
		return true;
	}

}
