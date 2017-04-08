
package net.eduard.api.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.Commands;

public class TeleportAllCommand extends Commands {
	public TeleportAllCommand() {
		super("teleportall");
	}
	public String message = "�6Voce teleportou todos ate voc�!";
	public String messageTarget = "�6Voce foi teleportado pelo jogador $player�6!";
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (API.onlyPlayer(sender)) {
			Player p = (Player) sender;
			for (Player d : API.getPlayers()) {
				if (d.equals(p))
					continue;
				d.teleport(p);
				API.chat(d,
						messageTarget.replace("$player", p.getDisplayName()));
			}
			API.chat(p,message);
		}
		return true;
	}

}
