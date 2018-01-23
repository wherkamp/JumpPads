package me.kingtux.kingjumppads;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class JumpListener implements Listener {
	private JumpPadsMain plugin;

	public JumpListener(JumpPadsMain pl) {
		plugin = pl;
	}

	@EventHandler
	public void Event(PlayerMoveEvent e) {
		List<String> enabledWorlds = plugin.getConfig().getStringList("Enabled-Worlds");
		if (enabledWorlds.contains("*") || enabledWorlds.contains(e.getPlayer().getLocation().getWorld().getName())) {
			Player player = e.getPlayer();
			Material bottomBlock = Material.getMaterial(plugin.getConfig().getString("BOTTOM_BLOCK").toUpperCase());
			Material topBlock = Material.getMaterial(plugin.getConfig().getString("TOP_BLOCK").toUpperCase());
			Double angle = plugin.getConfig().getDouble("ANGLE");
			String sound = plugin.getConfig().getString("Sound").toUpperCase();
			if ((player.getLocation().subtract(0, 1, 0).getBlock().getType().equals(bottomBlock)
					&& (player.getLocation().getBlock().getType().equals(topBlock)))) {
				Vector v = player.getLocation().getDirection().multiply(10).setY(angle);
				player.setVelocity(v);
				player.playSound(player.getLocation(), sound, 5.0F, 2.0F);
			}
		}
	}
}
