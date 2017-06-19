package net.eduard.api.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.gui.Kit;
import net.eduard.api.manager.GameAPI;
import net.eduard.api.manager.ItemAPI;

public class Teleporter extends Kit {
	public Teleporter() {
		setIcon(Material.BOW, "�fAo acertar a flecha voc� � teleportado at� ela!");
		add(ItemAPI.addEnchant(new ItemStack(Material.BOW), Enchantment.ARROW_DAMAGE, 1));
		add(new ItemStack(Material.ARROW, 10));

	}
	@EventHandler
	public void event(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.getShooter() instanceof Player) {
				Player p = (Player) arrow.getShooter();
				if (hasKit(p)) {
					GameAPI.teleport(p, arrow.getLocation());
				}

			}

		}
	}

}
