package me.kingtux.jumppads;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class JumpPadsMain extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new JumpListener(this), this);
		saveDefaultConfig();
		getLogger().log(Level.INFO, "JumpListener Pads has loaded! HELLO");
	}

	public void onDisable(){

	}
}
