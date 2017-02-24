package net.eduard.template;

import java.util.ArrayList;

import org.bukkit.Location;

/**
 * � o Mapa
 * @author Eduard-PC
 *
 */
public class Arena {
	private String name;
	private int minPlayersAmount=2,maxPlayersAmount=12;
	private Box map =  new Box();
	private Box feast =  new Box();
	private ArrayList<Box> miniFeasts = new ArrayList<>();
	private double reward;
	private ArrayList<Location> spawns = new ArrayList<>();
}
