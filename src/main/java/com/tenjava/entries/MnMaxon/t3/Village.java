package com.tenjava.entries.MnMaxon.t3;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;

public class Village {
	private int ID;

	public Village(ArrayList<Chunk> villageChunks) {
	}

	private Village(int ID) {
	}

	public int getId() {
		return ID;
	}

	public static Village get(int ID) {
		return new Village(ID);
	}

	public static int generateID() {
		YamlConfiguration cfg = Config.load("VillageData");
		int i = 0;
		while (cfg.get("Villages." + i) != null)
			i++;
		return i;
	}
}
