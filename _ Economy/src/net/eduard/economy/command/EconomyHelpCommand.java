
package net.eduard.economy.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.eduard.api.lib.manager.CommandManager;

public class EconomyHelpCommand extends CommandManager {

	public EconomyHelpCommand() {
		super("help","ajuda","?");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		return true;
	}

}
