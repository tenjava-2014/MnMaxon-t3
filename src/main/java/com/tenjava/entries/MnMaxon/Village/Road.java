package com.tenjava.entries.MnMaxon.Village;

import org.bukkit.Material;
import org.bukkit.World;

public class Road extends VillageChunk {
	public static final String name = "Road";

	public Road(World world, int X, int Z, Village village) {
		super(world, X, Z, village);
	}

	public void build() {
		if (north != null)
			for (int x = 7; x <= 8; x++)
				for (int z = 16; z >= 8; z--) {
					chunk.getWorld().getHighestBlockAt(x, z).getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(x, z).setType(Material.GRAVEL);
				}
		if (east != null)
			for (int z = 7; z <= 8; z++)
				for (int x = 16; x >= 8; x--) {
					chunk.getWorld().getHighestBlockAt(x, z).getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(x, z).setType(Material.GRAVEL);
				}
		if (south != null)
			for (int x = 7; x <= 8; x++)
				for (int z = 0; z <= 8; z++) {
					chunk.getWorld().getHighestBlockAt(x, z).getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(x, z).setType(Material.GRAVEL);
				}
		if (west != null)
			for (int z = 7; z <= 8; z++)
				for (int x = 16; x >= 8; x--) {
					chunk.getWorld().getHighestBlockAt(x, z).getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(x, z).setType(Material.GRAVEL);
				}
	}
}
