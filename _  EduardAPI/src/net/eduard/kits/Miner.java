package net.eduard.kits;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.API;
import net.eduard.api.gui.Kit;

public class Miner extends Kit {

	public Miner() {
		setIcon(Material.STONE_PICKAXE, "Minere muito rapido");
		ItemStack item = new ItemStack(Material.STONE_PICKAXE);
		API.add(item, Enchantment.DURABILITY, 2);
		API.add(item, Enchantment.DIG_SPEED, 2);
		add(item);
	}

	@EventHandler
	public void event(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (hasKit(p)) {
			if (API.isUsing(p, "PICKAXE")) {
				check(e.getBlock().getLocation(),p.getItemInHand());
			}
		}

	}
	public void check(Location loc,ItemStack item) {
		int range = 1;
		int  high = 1;
		int X = loc.getBlock().getX();
		int Y = loc.getBlock().getY();
		int Z = loc.getBlock().getZ();
		for (int x = X-range;x<=X+range;x++) {
			for (int z = Z-range;z<=Z+range;z++) {
				for (int y = Y;y<=Y+high;y++) {
					loc = new Location(loc.getWorld(), x, y, z);
					Material type = loc.getBlock().getType();
					if (type!=Material.AIR&(!type.name().contains("LOG"))) {
						loc.getBlock().breakNaturally(item);
					}
					
				}
			}
		}
	}
}
