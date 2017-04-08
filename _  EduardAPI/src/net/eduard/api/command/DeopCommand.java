
package net.eduard.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.Commands;

public class DeopCommand extends Commands {
	public DeopCommand() {
		super("deop");
	}
	public String messageTarget = "�6Voce removeu Op do jogador �e$target";
	public String message = "�6Voce agora n�o � mais Op!";
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			return false;
		}
		if (API.existsPlayer(sender, args[0])) {
			Player target = API.getPlayer(args[0]);
			target.setOp(false);
			API.chat(target, message);
			API.chat(sender,
					messageTarget.replace("$target", target.getDisplayName()));
		}

		return true;
	}
}
