package com.tenjava.entries.MnMaxon.Village;

import org.bukkit.Chunk;
import org.bukkit.World;

public class VillageChunk {
	public Chunk chunk;

	public VillageChunk(World world, int X, int Z) {
		chunk = world.getChunkAt(X, Z);
	}

	public void build() {
	}
}
