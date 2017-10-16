package net.eduard.api.command.essentials;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.CommandManager;
import net.eduard.api.setup.Mine;

public class GamemodeCommand extends CommandManager {

	public GamemodeCommand() {
		super("gamemode", "gm");
	}
	public String message = "�6Seu gamemode agora �: $gamemode";
	public String messageTarget = "�6O gamemode do $player agora �: $gamemode";

	public String getGamemode(Player player) {
		return Mine.toTitle(player.getGameMode().name());
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				} else {
					p.setGameMode(GameMode.CREATIVE);
				}
				API.chat(sender, message.replace("$gamemode", getGamemode(p)));

			} else
				return false;

		} else {
			GameMode gm = null;
			for (GameMode gameMode : GameMode.values()) {
				if (args[0].equalsIgnoreCase("" + gameMode.getValue())
						|| (args[0].equalsIgnoreCase(gameMode.name()))) {
					gm = gameMode;
				}
			}
			Player p = null;
			if (sender instanceof Player) {
				p = (Player) sender;
			}
			if (args.length >= 2) {
				if (API.existsPlayer(sender, args[1])) {
					p = Mine.getPlayer(args[1]);
					API.chat(sender,
							messageTarget.replace("$gamemode", getGamemode(p))
									.replace("$player", p.getDisplayName()));
				} else
					return true;;

			}
			if (p == null) {
				return false;
			}
			p.setGameMode(gm);
			API.chat(p, message.replace("$gamemode", getGamemode(p)));

		}
		return true;
	}
}
