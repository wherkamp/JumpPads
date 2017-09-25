package net.KingTux.JumpPads;

import org.bukkit.plugin.java.JavaPlugin;

public class Jumpads extends JavaPlugin {
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Jump(this), this);
		saveDefaultConfig();
		System.out.println("Jump Pads has loaded! HELLO");
	}

	public void onDisable() {
		System.out.println("Jump Pads has disabled! GOOD BYE");
	}
}
