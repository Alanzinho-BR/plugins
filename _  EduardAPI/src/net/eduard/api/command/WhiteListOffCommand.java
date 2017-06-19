
package net.eduard.api.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.eduard.api.manager.CMD;
import net.eduard.api.util.Cs;

public class WhiteListOffCommand extends CMD {

	public String message = "�6Voce desativou a Lista �fBranca";

	public WhiteListOffCommand() {
		super("off", "disable");

	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		Bukkit.setWhitelist(false);
		Cs.chat(sender,message);
		
		return true;
	}

}
