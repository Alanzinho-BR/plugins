
package net.eduard.essentials.command.economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.eduard.api.lib.manager.CommandManager;

public class EconomyRemoveCommand extends CommandManager {

	public EconomyRemoveCommand() {
		super("reload");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length ==0) {
			
		}
		
		return true;
	}

}
