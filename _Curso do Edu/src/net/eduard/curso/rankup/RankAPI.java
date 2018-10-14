package net.eduard.curso.rankup;

import net.eduard.api.lib.ConfigAPI;
import net.eduard.api.lib.storage.StorageAPI;
import net.eduard.curso.CursoMain;

public class RankAPI {

	private static ConfigAPI config = new ConfigAPI("rankup.yml", CursoMain.getInstance());
	private static RankManager manager;

	public static ConfigAPI getConfig() {
		return config;
	}

	public static void setConfig(ConfigAPI config) {
		RankAPI.config = config;
	}

	public static RankManager getManager() {
		return manager;
	}

	public static void setManager(RankManager manager) {
		RankAPI.manager = manager;
	}

	public static void reload() {
		StorageAPI.register(Rank.class);
		StorageAPI.register(RankManager.class);

		if (config.contains("ranks")) {

			manager = (RankManager) config.get("ranks");

			StorageAPI.updateReferences();
		} else {
			manager = new RankManager();
			Rank primeiro = new Rank();
			primeiro.setName("Base");
			primeiro.setLevel(1);
			manager.register(primeiro);
			save();
		}
	}

	public static void save() {
		config.set("ranks", manager);
		config.saveConfig();
	}
}
