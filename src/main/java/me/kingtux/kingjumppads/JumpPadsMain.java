package me.kingtux.kingjumppads;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class JumpPadsMain extends JavaPlugin {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JumpListener(this), this);
        saveDefaultConfig();
        Metrics metrics = new Metrics(this, 2127);
    }

    public void onDisable() {

    }
}
