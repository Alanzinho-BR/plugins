
package net.eduard.toquesuave.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.manager.CommandManager;
import net.eduard.api.setup.Mine;
import net.eduard.toquesuave.Main;

public class ToqueSuaveCommand extends CommandManager {

	public ToqueSuaveCommand() {
		super("toquesuave");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("�c/toquesuave [Jogador]");
		} else {
			String nome = args[0];
			Player player = Mine.getPlayer(nome);
			if (player == null) {
				sender.sendMessage("�cJogador invalido!");
			} else {
				if (Main.getInstance().getConfigs().contains("ToqueSuave")) {
					player.getInventory().addItem(Main.getInstance()
							.getConfigs().getItem("ToqueSuave"));
				}

			}
		}
		return true;
	}

}
