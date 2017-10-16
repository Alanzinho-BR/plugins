
package net.eduard.api.command.map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.eduard.api.API;
import net.eduard.api.manager.CommandManager;
import net.eduard.api.setup.Arena;

public class MapCopyCommand extends CommandManager {

	public MapCopyCommand() {
		super("copy","copiar");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (API.onlyPlayer(sender)) {
			Player p = (Player) sender;
			if (!API.POSITION1.containsKey(p)) {
				p.sendMessage("�bEduardAPI �2Posi��o 1 n�o foi setada!");
				return true;
			}
			if (!API.POSITION2.containsKey(p)) {
				p.sendMessage("�bEduardAPI �2Posi��o 2 n�o foi setada!");
				return true;
			}
			
			API.MAPS.put(p, new Arena(API.POSITION1.get(p),
					API.POSITION2.get(p), p.getLocation()));
			p.sendMessage("�bEduardAPI �6Mapa copiado!");
		}
		return true;
	}

}
