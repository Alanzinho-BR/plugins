
package net.eduard.witherspawn.command;

import net.eduard.api.manager.CommandManager;

public class WitherCommand extends CommandManager {
	
	public WitherCommand() {
		super("wither");
		register(new Help());
		register(new SetSpawn());
		register(new Spawn());
	}

}
