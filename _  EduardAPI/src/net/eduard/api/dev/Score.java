package net.eduard.api.dev;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.eduard.api.API;
import net.eduard.api.util.Extras;
import net.eduard.api.util.SimpleEffect;

@SuppressWarnings("unused")
public class Score {

	
	private Game updater = new Game(1).timer(new SimpleEffect() {

		public void effect() {
			if (autoUpdate) {
				update();
			}
		}
	});
	private Game scroller = new Game(2L).timer(new SimpleEffect() {

		public void effect() {
			if (autoScroll) {
				String newTitle = ChatColor.stripColor(name + getEmpty(10));
				// vamo supor que size = 30
				int size = 32 - scrollPrefix.length();
				if (newTitle.length() <= size) {
					currentChar = 0;
					setTitle(name);
				} else {
					if (currentChar >= newTitle.length()) {
						currentChar = 0;
					}

					String scrolled = "";
					String moved = newTitle.substring(currentChar);
					if (moved.length() > size) {
						scrolled = moved.substring(0, size);
					} else {
						int rest = size - moved.length();
						scrolled = moved.substring(0, moved.length());
						scrolled += newTitle.substring(0, rest);
					}
					setTitle(scrollPrefix + scrolled);
					currentChar++;
				}
			}
		}
	});

	private boolean autoUpdate = true;
	private boolean autoScroll = true;
	private String scrollPrefix = "�6";
	private String scrollSuffix = "�2 ";
	private String name;
	private int currentChar;
	private long scrollerTime = 2L;
	private long updaterTime = 1;
	private Player player;
	private Scoreboard scoreboard;
	private Objective objective;
	private Objective health;
	private ArrayList<String> lines = new ArrayList<>();
	private HashMap<Integer, OfflinePlayer> slots = new HashMap<>();
	private HashMap<Integer, Team> teams = new HashMap<>();

	
	public Score(String name) {
		scoreboard = API.newScoreboard();
		objective = getObjective("display");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		health = scoreboard.registerNewObjective("healthDisplay", "health");
		health.setDisplaySlot(DisplaySlot.BELOW_NAME);
		health.setDisplayName("" + Extras.getRedHeart());
		setName(name);
		for (int i = 1; i < 16; i++) {
			slots.put(i, getDisplay("SLOT-" + i));
		}
		for (int i = 1; i < 16; i++) {
			teams.put(i, getTeam("TEAM-" + i));
		}
		setEmpty(1);
	}

	public Score() {
		this("Scoreboard");
	}
	public void setScoreboard(Player p) {
		p.setScoreboard(scoreboard);
	}
	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public void setName(String name) {
		this.name = name;
		currentChar = 0;
		setTitle(name);
	}

	public void setTitle(String title) {
		objective.setDisplayName(API.toText(32, title));
	}

	public Objective getObjective(String name) {

		name = API.toText(16, name);
		if (scoreboard.getObjective(name) == null) {
			scoreboard.registerNewObjective(name, name);
		}
		return scoreboard.getObjective(name);
	}

	public Team getTeam(String name) {

		name = API.toText(16, name);
		if (scoreboard.getTeam(name) == null) {
			scoreboard.registerNewTeam(name);
		}
		return scoreboard.getTeam(name);
	}

	private int getId(int id) {

		if (id < 0) {
			id = 1;
		}
		if (id > 15) {
			id = 15;
		}
		return id;
	}

	public void set(int slot, String display) {
		slot = getId(slot);
		teams.get(slot).removePlayer(slots.get(slot));
		scoreboard.resetScores(slots.get(slot));
		display = API.toText(16 * 3, display);
		OfflinePlayer text = null;
		if (display.length() > 16 * 2) {
			text = getDisplay(display.substring(16, 16 * 2));
			Team team = teams.get(slot);
			team.addPlayer(text);
			team.setPrefix(display.substring(0, 16));
			team.setSuffix(display.substring(16 * 2, display.length() - 1));

		} else if (display.length() > 16) {
			text = getDisplay(display.substring(16, display.length() - 1));
			Team team = teams.get(slot);
			team.addPlayer(text);
			team.setPrefix(display.substring(0, 16));
		} else {
			text = getDisplay(display);
			slots.put(slot, text);
		}
		objective.getScore(text).setScore(slot);
	}

	private String getEmpty(int size) {

		StringBuilder empty = new StringBuilder();
		for (int i = 0; i < size; i++) {
			empty.append(" ");
		}
		return empty.toString();
	}

	private OfflinePlayer getDisplay(String display) {
		@SuppressWarnings("deprecation")
		OfflinePlayer text = Bukkit.getOfflinePlayer(display);
		return text;
	}

	public void setEmpty(int slot) {
		slot = getId(slot);
		set(slot, "" + ChatColor.values()[slot - 1] + getEmpty(14));
	}

	public void remove(int slot) {
		slot = getId(slot);
		scoreboard.resetScores(slots.get(slot));
	}

	public void update() {
		int id = 15;
		for (String line : lines) {
			if (player != null) {
				line = API.getText(line, player);
			}
			set(id, line);
			id--;
			if (id == 0)
				break;
		}
	}

	
	public void use(Player p) {
		p.setScoreboard(scoreboard);
		;
	}
}
