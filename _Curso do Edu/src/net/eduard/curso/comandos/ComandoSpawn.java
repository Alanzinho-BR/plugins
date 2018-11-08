package net.eduard.curso.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.curso.CursoMain;

public class ComandoSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (CursoMain.getConfigs().contains("spawn")) {
				p.teleport(CursoMain.getConfigs().getLocation("spawn"));

				p.sendMessage("�aVoc� foi teleportado para o Spawn.");

			} else {
				p.sendMessage("�cO spawn n�o foi setado.");
			}

		}
		return false;
	}

}
