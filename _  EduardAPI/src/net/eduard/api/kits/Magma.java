package net.eduard.api.kits;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import net.eduard.api.API;
import net.eduard.api.game.Potions;
import net.eduard.api.gui.Kit;
import net.eduard.api.manager.WorldAPI;

public class Magma extends Kit {

	public int effectSeconds = 5;
	public double chance = 0.35;

	public Magma() {
		setIcon(Material.MAGMA_CREAM, "�fSeja invuneravel a Fogo e Lava");
		setTime(1);
		getPotions().add(new Potions(PotionEffectType.CONFUSION, 0, 20*5));
		getPotions().add(new Potions(PotionEffectType.POISON, 0, 20*5));
	}

	@Override
	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (hasKit(p)) {
				if (API.getChance(chance))
					e.getDamager().setFireTicks(20 * effectSeconds);
			}

		}
	}

	@EventHandler
	public void event(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (e.getCause() == DamageCause.FIRE
					| e.getCause() == DamageCause.FIRE_TICK
					| e.getCause() == DamageCause.LAVA) {
				if (hasKit(p)) {
					e.setCancelled(true);
				}
			}

		}
	}

	@EventHandler
	public void event(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (hasKit(p)) {
			if (!WorldAPI.equals2(e.getFrom(), e.getTo())) {
				Material type = p.getLocation().getBlock()
						.getRelative(BlockFace.DOWN).getType();
				if (type == Material.WATER
						| type == Material.STATIONARY_WATER) {
					givePotions(p);
				}
			}
		}
	}

}
