package net.eduard.tutoriais.kits;

import org.bukkit.Material;

import net.eduard.api.lib.game.Ability;
import net.eduard.api.lib.game.KitType;


public class Tower extends Ability{

	public Tower() {
		setIcon(Material.DIAMOND_BOOTS, "�fJunte a for�a do Stomper com o Worm");
		add(KitType.STOMPER);
		add(KitType.WORM);
	}
	
	
}
