package net.eduard.api.tutorial.armazenamento;

import net.eduard.api.setup.VaultAPI;

public class ComoAdicionarCoisasNoPermissionEX {
	public ComoAdicionarCoisasNoPermissionEX() {
		VaultAPI.getChat().getGroupInfoDouble("null", "Membro", "price", 20);
	}
}
