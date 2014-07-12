package com.tenjava.entries.MnMaxon.Village;

import org.bukkit.Bukkit;
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
					Bukkit.broadcastMessage(""
							+ chunk.getWorld()
									.getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
									.getType().toString());
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.setType(Material.GRAVEL);
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ());
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ());
					Bukkit.broadcastMessage(""
							+ chunk.getWorld()
									.getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
									.getType().toString());
				}
		if (east != null)
			for (int z = 7; z <= 8; z++)
				for (int x = 16; x >= 8; x--) {
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.setType(Material.GRAVEL);
				}
		if (south != null)
			for (int x = 7; x <= 8; x++)
				for (int z = 0; z <= 8; z++) {
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.setType(Material.GRAVEL);
				}
		if (west != null)
			for (int z = 7; z <= 8; z++)
				for (int x = 16; x >= 8; x--) {
					Boolean good = false;
					while (!good) {
						Material blockType = chunk.getWorld()
								.getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
								.getRelative(0, 0, 0).getType();
						if (blockType.equals(Material.LOG_2) || blockType.equals(Material.LEAVES)
								|| blockType.equals(Material.LEAVES_2) || blockType.equals(Material.LOG)
								|| blockType.equals(Material.LONG_GRASS))
							chunk.getWorld()
									.getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
									.getRelative(0, 0, 0).setType(Material.AIR);
						else
							good = true;
					}
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.getRelative(0, -1, 0).setType(Material.COBBLESTONE);
					chunk.getWorld().getHighestBlockAt(chunk.getBlock(x, 0, z).getX(), chunk.getBlock(x, 0, z).getZ())
							.setType(Material.GRAVEL);
				}
		Bukkit.broadcastMessage("" + chunk.getWorld().getHighestBlockAt(16, 16).getType().toString());
	}
}
