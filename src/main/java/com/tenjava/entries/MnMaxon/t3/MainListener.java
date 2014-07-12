package com.tenjava.entries.MnMaxon.t3;

import java.util.ArrayList;

import org.bukkit.Chunk;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class MainListener implements Listener {
	@EventHandler
	public static void newChunk(ChunkLoadEvent e) {
		if (e.isNewChunk()) {
			YamlConfiguration cfg = Config.load("Config.yml");
			cfg = Config.setConfigDefault(cfg, "Viallages.Max Chunks");
			cfg = Config.setConfigDefault(cfg, "Viallages.Percent of chunks");
			cfg = Config.setConfigDefault(cfg, "Dungeons.Max Chunks");
			cfg = Config.setConfigDefault(cfg, "Dungeons.Percent of chunks");
			ArrayList<Chunk> villageChunks = new ArrayList<Chunk>();
			ArrayList<Chunk> dungeonChunks = new ArrayList<Chunk>();
			if (cfg.getDouble("Viallages.Percent of chunks") > 0.0
					&& Math.rint(Math.random() * 100.0 / cfg.getDouble("Viallages.Percent of chunks")) == 0
					&& cfg.getInt("Viallages.Max Chunks") > 0) {
				villageChunks.add(e.getChunk());
				e.getChunk();
			}
			if (villageChunks.isEmpty() && cfg.getDouble("Dungeons.Percent of chunks") > 0.0
					&& Math.rint(Math.random() * 100.0 / cfg.getDouble("Dungeons.Percent of chunks")) == 0
					&& cfg.getInt("Dungeons.Max Chunks") > 0) {
			}
		}
	}

	private static ArrayList<Chunk> getSurroundingChunks(Chunk chunk, ArrayList<Chunk> selectedChunks, int size) {
		YamlConfiguration cfg = Config.load("Config.yml");
		if (!selectedChunks.contains(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ()))
				&& Math.rint(Math.random()) == 1 && selectedChunks.size() <= size) {
			selectedChunks.add(chunk.getWorld().getChunkAt(chunk.getX() + 1, chunk.getZ()));
		}
		return selectedChunks;
	}
}