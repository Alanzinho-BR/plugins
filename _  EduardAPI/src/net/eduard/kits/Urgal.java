package net.eduard.kits;

import org.bukkit.Material;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import net.eduard.api.gui.Kit;


public class Urgal extends Kit{

	public Urgal() {
		setIcon(Material.POTION,8261, "Ganhe po��es que te d�o muita for�a");
		add(new Potion(PotionType.STRENGTH,1).toItemStack(2));
	}
}
