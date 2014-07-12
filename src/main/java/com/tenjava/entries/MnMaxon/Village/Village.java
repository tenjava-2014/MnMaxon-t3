package com.tenjava.entries.MnMaxon.Village;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;

import com.tenjava.entries.MnMaxon.t3.Config;

public class Village {
	public int ID;

	public Village(ArrayList<Chunk> chunks) {
		YamlConfiguration data = Config.load("VillageData");
		ArrayList<VillageChunk> vcs = new ArrayList<VillageChunk>();
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

			VillageChunk vc = new Road(chunk.getWorld(), chunk.getX(), chunk.getZ(), this);
			vc.north = north;
			vc.south = south;
			vc.east = east;
			vc.west = west;
			vcs.add(vc);
		}

		Boolean hasTownCenter = false;
		VillageChunk setCenter = null;

		for (VillageChunk vc : vcs) {
			int count = vc.amountOfSurroundingChunks();
			if (count == 4)
				if (!hasTownCenter) {
					setCenter = vc;
					hasTownCenter = true;
				}
		}
		for (VillageChunk vc : vcs) {
			int count = vc.amountOfSurroundingChunks();
			if (count == 3)
				if (!hasTownCenter) {
					setCenter = vc;
					hasTownCenter = true;
				}
		}
		for (VillageChunk vc : vcs) {
			int count = vc.amountOfSurroundingChunks();
			if (count == 2)
				if (!hasTownCenter) {
					setCenter = vc;
					hasTownCenter = true;
				}
		}
		for (VillageChunk vc : vcs) {
			int count = vc.amountOfSurroundingChunks();
			if (count == 1)
				if (!hasTownCenter) {
					setCenter = vc;
					hasTownCenter = true;
				}
		}
		if (setCenter == null)
			return;
		vcs.remove(setCenter);
		TownCenter tc = (TownCenter) setCenter;
		vcs.add(tc);
		int i = 0;
		for (VillageChunk vc : vcs) {
			vc.build();
			data.set("Villages." + ID + ".chunk." + i + ".X", vc.chunk.getX());
			data.set("Villages." + ID + ".chunk." + i + ".Z", vc.chunk.getZ());
			data.set("Villages." + ID + ".chunk." + i + ".Type", vc.getType());
			i++;
		}
		Config.save(data, "VillageData");
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
