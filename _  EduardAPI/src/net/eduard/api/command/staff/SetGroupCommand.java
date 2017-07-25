package net.eduard.api.command.staff;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import net.eduard.api.API;
import net.eduard.api.config.ConfigSection;
import net.eduard.api.config.Config;
import net.eduard.api.game.Title;
import net.eduard.api.manager.CMD;
import net.eduard.api.manager.VaultAPI;
import net.eduard.api.util.Save;

public class SetGroupCommand extends CMD implements Save {
	public List<String> messages = new ArrayList<>();
	public Config config = new Config("group.yml");
	public Title title = new Title(20, 20, 20, "$player", "$group");
	public String defaultGroup = "membro";

	public String getGroup(Player player) {
		UUID id = player.getUniqueId();
		config.add(id.toString(), defaultGroup);
		return config.getString(id.toString());
	}

	public SetGroupCommand() {
		super("setgroup");

	}
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (args.length <= 1) {
			ConfigSection.chat(sender, getUsage());

		} else {
			// /setgroup dono eduard
			// /setgroup eduard dono
			String name = args[0];
			String group = args[1];
			if (API.existsPlayer(sender, name)) {
				Player target = API.getPlayer(name);
				Title t = title.clone();
				VaultAPI.getPermission().playerAddGroup(target, group);
				VaultAPI.getPermission().playerRemoveGroup(target, getGroup(target));
				config.set(target.getUniqueId().toString(), group);
				t.setSubTitle(getValues(t.getSubTitle(), name, group));
				t.setTitle(getValues(t.getTitle(), name, group));
				for (Player player : API.getPlayers()) {
					t.create(player);
					for (String message : messages) {
						ConfigSection.chat(player, getValues(message, name, group));
					}
				}

			}
		}
		return true;
	}
	@Override
	public Object get(ConfigSection section) {

		messages = section.getMessages("messages");
		return null;
	}
	public String getValues(String value, String name, String group) {
		return value.replace("$player", name).replace("$group", group);
	}
	@EventHandler
	public void event(PlayerJoinEvent e) {
		getGroup(e.getPlayer());
	}

}
