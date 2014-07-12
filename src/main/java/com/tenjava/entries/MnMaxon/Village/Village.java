package com.tenjava.entries.MnMaxon.Village;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;

import com.tenjava.entries.MnMaxon.t3.Config;

public class Village {
	private int ID;

	public Village(ArrayList<Chunk> chunks) {
		YamlConfiguration data = Config.load("VillageData");
		ArrayList<VillageChunk> vc = new ArrayList<VillageChunk>();
		for (Chunk chunk : chunks) {
		}
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
		YamlConfiguration data = Config.load("VillageData");
		int i = 0;
		while (data.get("Villages." + i) != null)
			i++;
		return i;
	}
}
