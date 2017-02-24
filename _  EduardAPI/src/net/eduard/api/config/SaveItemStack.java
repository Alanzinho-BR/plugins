package net.eduard.api.config;

import java.util.List;
import java.util.Map.Entry;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import net.eduard.api.API;
import net.eduard.api.util.Save;

public class SaveItemStack implements Save {

	public ItemStack get(Section section) {
		int id = section.getInt("id");
		int amount = section.getInt("amount");
		int data = section.getInt("data");
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(id, amount, (short) data);
		String name = section.message("name");
		if (!name.isEmpty()) {
			API.setName(item, name);
		}
		List<String> lore = section.getMessages("lore");
		if (!lore.isEmpty()) {
			API.setLore(item, lore);
		}
		String enchants = section.getString("enchants");
		if (!enchants.isEmpty()) {
			if (enchants.contains(", ")) {
				String[] split = enchants.split(", ");
				for (String enchs : split) {
					String[] sub = enchs.split("-");
					@SuppressWarnings("deprecation")
					Enchantment ench = Enchantment.getById(API.toInt(sub[0]));
					Integer level = API.toInt(sub[1]);
					item.addUnsafeEnchantment(ench, level);

				}
			} else {
				String[] split = enchants.split("-");
				@SuppressWarnings("deprecation")
				Enchantment ench = Enchantment.getById(API.toInt(split[0]));
				Integer level = API.toInt(split[1]);
				item.addUnsafeEnchantment(ench, level);

			}
		}
		return item;
	}

	@SuppressWarnings("deprecation")
	public void save(Section section, Object value) {
		ItemStack item = (ItemStack) value;
		section.set("id", item.getTypeId());
		section.set("data", item.getDurability());
		section.set("amount", item.getAmount());
		section.set("name", API.getName(item));
		section.set("lore", API.getLore(item));
		String enchants = "";
		if (item.getItemMeta().hasEnchants()) {
			StringBuilder b = new StringBuilder();
			int id = 0;
			for (Entry<Enchantment, Integer> map : item.getEnchantments().entrySet()) {
				if (id > 0)
					b.append(", ");
				Enchantment enchantment = map.getKey();
				b.append(enchantment.getId() + "-" + map.getValue());
				id++;
			}
			enchants = b.toString();
		}
		section.set("enchants", enchants);
	};

}
