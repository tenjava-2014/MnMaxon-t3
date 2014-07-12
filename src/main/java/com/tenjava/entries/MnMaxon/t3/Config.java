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
}