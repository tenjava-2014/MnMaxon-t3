package com.tenjava.entries.MnMaxon.Village;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import com.tenjava.entries.MnMaxon.t3.Config;

public class VillageChunk {
	public static final String name = null;
	public Chunk chunk;
	public Chunk north;
	public Chunk south;
	public Chunk east;
	public Chunk west;
	public int id;
	public Village village;

	public VillageChunk(World world, int X, int Z, Village village) {
		setVillageChunk(world, X, Z, village);
	}

	public VillageChunk(int villageID, int chunkID) {
		id = chunkID;
		YamlConfiguration data = Config.load("VillageData");
		setVillageChunk(Bukkit.getWorld(data.getString(villageID + ".World")),
				data.getInt(villageID + "." + id + ".X"), data.getInt(villageID + "." + id + ".Z"),
				Village.get(villageID));
	}

	private void setVillageChunk(World world, int X, int Z, Village village) {
		this.village = village;
		chunk = world.getChunkAt(X, Z);
	}

	public void build() {
	}

	public int amountOfSurroundingChunks() {
		int count = 0;
		if (north != null)
			count++;
		if (south != null)
			count++;
		if (east != null)
			count++;
		if (west != null)
			count++;
		return count;
	}
}
