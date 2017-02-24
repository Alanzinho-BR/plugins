package net.eduard.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.gui.Kit;


public class FireMan extends Kit {
	public FireMan() {
		setIcon(Material.LAVA_BUCKET, "Seje imune ao fogo");
		add(new ItemStack(Material.WATER_BUCKET));
	}

	@EventHandler
	public void event(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			DamageCause type = e.getCause();
			if (getPlayers().contains(p)) {
				if (type == DamageCause.LAVA | type == DamageCause.FIRE | type == DamageCause.FIRE_TICK) {
					e.setCancelled(true);
				}
			}
			
		}
	}
}
