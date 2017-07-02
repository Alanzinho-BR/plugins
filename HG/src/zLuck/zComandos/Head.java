package zLuck.zComandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import br.com.piracraft.api.Main;
import zLuck.zUteis.Uteis;

public class Head implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		Player p = (Player) sender;
		
		if (label.equalsIgnoreCase("head")) {
			if (Main.isStaff(p)) {
				if (args.length == 0) {
					p.sendMessage("�cUse /head [jogador]");
					return true;
				}
				if (args.length == 1) {
			        ItemStack cabe�a = new ItemStack(Material.SKULL_ITEM);
			        cabe�a.setDurability((short)3);
			        SkullMeta cabe�ameta = (SkullMeta)cabe�a.getItemMeta();
			        cabe�ameta.setOwner(args[0]);
			        cabe�a.setItemMeta(cabe�ameta);
			        p.getInventory().addItem(cabe�a);
			  	    p.sendMessage(Uteis.prefix + " �7Voce pegou a cabe�a de �c�l" + args[0]);
				}
			} else {
				p.sendMessage(Uteis.sempermiss�o);
			}
		}
		return false;
	}
	
	

}
