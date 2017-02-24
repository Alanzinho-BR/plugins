
package net.eduard.hg.manager;

import net.eduard.hg.HGState;
import net.eduard.hg.Main;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerStart {

	public static int time;

	public TimerStart() {
		Main.state = HGState.START;
		time = 10;
		Bukkit.broadcastMessage("�6HG vai come�ar em breve!");
		new BukkitRunnable() {

			public void run() {

				time--;
				boolean message = false;
				if (time == 0) {
					if(Main.players.size()<1) {
						time = 10;
					}else {
						cancel();
						Bukkit.broadcastMessage("�6HG come�ou!");
						new TimerInvunerable();
					}
				} else if (time < 10) {
					message = true;
				} else if (time % 20 == 0) {
					message = true;
				}
				if (message) {
					Bukkit.broadcastMessage(
						"�6HG vai come�ar em " + time + " segundos!");
				}
				
			}
		}.runTaskTimer(Main.plugin, 20, 20);
	}

}
