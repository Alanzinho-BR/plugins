package net.eduard.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length == 0) {
			return true;
		}

		String cmd = args[0];

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (command.getName().equalsIgnoreCase("warp")) {

				if (cmd.equalsIgnoreCase("help")) {
					p.sendMessage("�c/warp <warp> teleporte ate o warp");

				} else if (cmd.equalsIgnoreCase("set")
						| cmd.equalsIgnoreCase("create")) {

					// warp set $warp

					if (args.length == 1) {

						p.sendMessage("�cDigite: /warp set <warp>");

					} else {
						String name = args[1];
						Warp warp = new Warp(name, p.getLocation());
						Main.getWarp().put(name.toLowerCase(), warp);
						// /warp teste
						// /warp Teste

						p.sendMessage(Main.message("Warp set").replace("<warp>",
								name));

					}

				} else if (cmd.equalsIgnoreCase("del")
						| cmd.equalsIgnoreCase("delete")
						| cmd.equalsIgnoreCase("remove")) {
					
					
					if (args.length == 1) {

						p.sendMessage("�cDigite: /warp delete <warp>");

					} else {
						String name = args[1];
						Main.getWarp().remove(name.toLowerCase());

						p.sendMessage(Main.message("Warp delete").replace("<warp>",
								name));

					}

				} else if (cmd.equalsIgnoreCase("list")) {

					sender.sendMessage(Main.message("Warp list")
							.replace("$warps", Main.getWarpsNames().toString()
									.replace("[", "").replace("]", "")));

				} else {
					String name = cmd;
					if (Main.getWarp().containsKey(name)) {

						Warp warp = Main.getWarp().get(name);
						p.teleport(warp.getLocation());
						p.sendMessage(Main.message("On Warp").replace("<warp>",
								name));

					} else {
						p.sendMessage(Main.message("Invalid Warp")
								.replace("<warp>", name));

					}
				}

			} else {

			}

		}
		// warp set
		// warp <warp>

		// warp del
		// warp list

		// warps|setwarp|delwarp

		return true;
	}

}
