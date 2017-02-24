package net.eduard.template.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import net.eduard.template.Main;

public class TrocaRapida implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void event(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand() == null)
			return;
		if (Main.admins.contains(p))
			if (e.getAction() == Action.RIGHT_CLICK_AIR|e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getMaterial() == Material.MAGMA_CREAM) {
					p.chat("/comando");
					p.updateInventory();
					new BukkitRunnable() {

						public void run() {
							p.chat("/comando");
						}
					}.runTaskLater(Main.plugin,10);
					e.setCancelled(true);
					// Faz algo
					
				}
			}
	}
}
