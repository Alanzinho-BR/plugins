package net.eduard.tutoriais;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ComoRegistrarComando {

	public static void registrarComando() {
		PluginCommand comando = Bukkit.getPluginCommand("comando");
		comando.setExecutor(new ComoCriarComando());
		comando.setPermission("permissao.usar");
		comando.setPermissionMessage("�cVoce nao tem permissao para usar este comando!");
		comando.setUsage("/comando usar [jogador]");
		comando.setAliases(Arrays.asList("comando2", "cmand"));
		comando.setDescription("�aUma outra descri��o para este comando");
		comando.setTabCompleter(new ComoCriarTabCompleter());
	}

	public static void segundaFormaDeRegistrar(JavaPlugin plugin) {
		PluginCommand comando = plugin.getCommand("comando");
		comando.setExecutor(new ComoCriarComando());
		comando.setTabCompleter(new ComoCriarTabCompleter());
	}

}
