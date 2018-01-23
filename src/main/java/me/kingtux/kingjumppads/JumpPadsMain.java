package me.kingtux.kingjumppads;

import org.bukkit.plugin.java.JavaPlugin;

public class JumpPadsMain extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new JumpListener(this), this);
		saveDefaultConfig();
		BStats metrics = new BStats(this);
	}

	public void onDisable(){

	}
}
