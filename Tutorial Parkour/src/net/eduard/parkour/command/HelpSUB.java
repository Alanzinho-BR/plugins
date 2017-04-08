package net.eduard.parkour.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.eduard.api.manager.SubCommands;

public class HelpSUB extends SubCommands {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("�b�l-=-=-=-=-=-=-=- �6�lHELP �b�l-=-=-=-=-=-=-=-=");
		if (sender.hasPermission("parkour.admin")) {
			sender.sendMessage("�a/parkour create|delete �b<arena>");
			sender.sendMessage("�a/parkour setspawn �b<arena>");
			sender.sendMessage("�a/parkour setend �b<arena>");
			sender.sendMessage("�a/parkour reload");
			sender.sendMessage("�a/parkour setlobby");
		}
		sender.sendMessage("�a/parkour play|jogar");
		sender.sendMessage("�a/parkour help");
		sender.sendMessage("�a/parkour lobby");

		return true;
	}

}
