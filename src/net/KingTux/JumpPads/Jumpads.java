package net.KingTux.JumpPads;

import org.bukkit.plugin.java.JavaPlugin;

public class Jumpads extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Jump(this), this);
saveDefaultConfig();
	}
}
