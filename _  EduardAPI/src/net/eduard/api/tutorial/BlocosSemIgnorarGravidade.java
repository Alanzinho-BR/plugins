package net.eduard.api.tutorial;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

import net.eduard.api.manager.Manager;

public class BlocosSemIgnorarGravidade extends Manager{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void quandoCriarBloco(BlockPlaceEvent e) {
		if (e.getBlock().getRelative(BlockFace.DOWN).getType()!=Material.AIR) {
			return;
		}
		e.getBlock().getWorld().spawnFallingBlock(e.getBlock().getLocation(), e.getBlock().getType(), e.getBlock().getData());
	}

}
