package com.tenjava.entries.MnMaxon.Village;

import org.bukkit.Chunk;
import org.bukkit.World;

public class VillageChunk {
	public Chunk chunk;
	public Chunk north;
	public Chunk south;
	public Chunk east;
	public Chunk west;

	public VillageChunk(World world, int X, int Z) {
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
