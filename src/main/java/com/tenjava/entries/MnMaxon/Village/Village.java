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
			Chunk north = null;
			Chunk south = null;
			Chunk east = null;
			Chunk west = null;
			if (chunks.contains(chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() + 1)))
				north = chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() + 1);

			if (chunks.contains(chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() - 1)))
				south = chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() - 1);

			if (chunks.contains(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ())))
				east = chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ());

			if (chunks.contains(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ())))
				west = chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ());
			
			if(){}
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
