package com.tenjava.entries.MnMaxon.t3;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import com.tenjava.entries.MnMaxon.Dungeon.Dungeon;
import com.tenjava.entries.MnMaxon.Village.Village;

public class MainListener implements Listener {
	@EventHandler
	public static void newChunk(ChunkLoadEvent e) {
		if (e.isNewChunk()) {
			YamlConfiguration cfg = Config.load("Config.yml");
			cfg = Config.setConfigDefault(cfg, "Villages.Max Chunks");
			cfg = Config.setConfigDefault(cfg, "Villages.Percent of chunks");
			cfg = Config.setConfigDefault(cfg, "Dungeons.Max Chunks");
			cfg = Config.setConfigDefault(cfg, "Dungeons.Percent of chunks");
			ArrayList<Chunk> villageChunks = new ArrayList<Chunk>();
			ArrayList<Chunk> dungeonChunks = new ArrayList<Chunk>();
			if (cfg.getDouble("Villages.Percent of chunks") > 0.0
					&& Math.rint(Math.random() * 100.0 / cfg.getDouble("Villages.Percent of chunks")) == 0
					&& cfg.getInt("Villages.Max Chunks") > 0) {
				villageChunks.add(e.getChunk());
				int size = cfg.getInt("Villages.Max Chunks") / 2;
				size = (int) (size + Math.rint((cfg.getInt("Villages.Max Chunks") - size) * Math.random()));
				while (villageChunks.size() < size)
					villageChunks = getSurroundingChunks(
							villageChunks.get((int) (Math.random() * (villageChunks.size() - 1))), villageChunks, size);
				new Village(villageChunks);
			}
			if (cfg.getDouble("Dungeons.Percent of chunks") > 0.0
					&& Math.rint(Math.random() * 100.0 / cfg.getDouble("Dungeons.Percent of chunks")) == 0
					&& cfg.getInt("Dungeons.Max Chunks") > 0) {
				dungeonChunks.add(e.getChunk());
				int size = cfg.getInt("Dungeons.Max Chunks") / 2;
				size = (int) (size + Math.rint((cfg.getInt("Dungeons.Max Chunks") - size) * Math.random()));
				while (dungeonChunks.size() < size)
					dungeonChunks = getSurroundingChunks(
							dungeonChunks.get((int) (Math.random() * (dungeonChunks.size() - 1))), dungeonChunks, size);
				new Dungeon(dungeonChunks);
			}
		}
	}

	private static ArrayList<Chunk> getSurroundingChunks(Chunk chunk, ArrayList<Chunk> selectedChunks, int size) {
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ()))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ()));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ() - 1))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ() - 1));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ()))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ() + 1));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() + 1))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() + 1));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() - 1))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX(), chunk.getZ() - 1));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ()))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ()));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ() - 1))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ() - 1));
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ() + 1))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size)
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() - 1, chunk.getZ() + 1));
		return selectedChunks;
	}
}