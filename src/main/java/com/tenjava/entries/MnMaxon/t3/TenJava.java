package com.tenjava.entries.MnMaxon.t3;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class TenJava extends JavaPlugin {
	public static String dataFolder;

	@Override
	public void onEnable() {
		dataFolder = this.getDataFolder().getPath();
		getServer().getPluginManager().registerEvents(new MainListener(), this);
		YamlConfiguration cfg = Config.load("Config.yml");
		cfg.set("Viallages.Max Chunks", 10);
		cfg.set("Viallages.Percent of chunks", .1);
		Config.save(cfg, "Config.yml");
	}

	@Override
	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return false;
	}
}