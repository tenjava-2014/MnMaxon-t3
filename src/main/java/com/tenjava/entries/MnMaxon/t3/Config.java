package com.tenjava.entries.MnMaxon.t3;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	public static YamlConfiguration load(String fileName) {
		if (!fileName.contains(TenJava.dataFolder))
			fileName = TenJava.dataFolder + "/" + fileName;
		File file = new File(fileName);
		if (!file.exists()) {
			new File(TenJava.dataFolder).mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return YamlConfiguration.loadConfiguration(file);
	}

	public static void save(YamlConfiguration cfg, String fileName) {
		if (!fileName.contains(TenJava.dataFolder))
			fileName = TenJava.dataFolder + "/" + fileName;
		File file = new File(fileName);
		if (!file.exists()) {
			file.mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static YamlConfiguration setConfigDefault(YamlConfiguration cfg, String setting) {
		if (cfg.get(setting) == null)
			if (setting.equals("Villages.Max Chunks"))
				cfg.set(setting, 10);
			else if (setting.equals("Villages.Percent of chunks"))
				cfg.set(setting, .1);
			else if (setting.equals("Dungeons.Max Chunks"))
				cfg.set(setting, 10);
			else if (setting.equals("Dungeons.Percent of chunks"))
				cfg.set(setting, .1);
		return cfg;
	}
}