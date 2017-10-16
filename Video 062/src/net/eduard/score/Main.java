
package net.eduard.score;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.eduard.api.setup.Mine;
import net.eduard.api.setup.Mine.DisplayBoard;

public class Main extends JavaPlugin implements Listener {

	public HashMap<Player, DisplayBoard> scoreboards = new HashMap<>();

	@Override
	public void onEnable() {
		Mine.event(this,this);
		
		Mine.timer(this,20,new Runnable() {

			@Override
			public void run() {
				updateScoreboards();
			}
		});
	}
	public void updateScoreboards() {
		for (Entry<Player, DisplayBoard> map : scoreboards.entrySet()) {
			updateScoreboard(map.getKey(), map.getValue());
		}
	}
	public void updateScoreboard(Player p, DisplayBoard score) {
		score.empty(10);
		score.set(8, "�aNick: �6" + p.getDisplayName());
		score.set(6, "�3Kills: �e" + p.getStatistic(Statistic.PLAYER_KILLS));
		score.set(4, "�3Deaths: �e" + p.getStatistic(Statistic.DEATHS));
	}
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		scoreboards.remove(e.getPlayer());
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		DisplayBoard score = new DisplayBoard("�6�lSky�f�lLegend");
		score.empty(10);
		updateScoreboard(p, score);
		score.apply(p);
	}

}
