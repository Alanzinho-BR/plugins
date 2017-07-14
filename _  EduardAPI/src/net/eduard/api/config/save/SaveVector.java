package net.eduard.api.config.save;

import org.bukkit.util.Vector;

import net.eduard.api.config.Save;
import net.eduard.api.config.Section;

public class SaveVector implements Save{

	public Object get(Section section) {
		return new Vector(section.getDouble("x"),section.getDouble("y") , section.getDouble("z"));
	}

	public void save(Section section, Object value) {
		if (value instanceof Vector) {
			Vector vector = (Vector) value;
			section.set("x",vector.getX());
			section.set("y",vector.getY());
			section.set("z",vector.getZ());
			
		}
	}

}
