package me.kingtux.kingjumppads;

import org.bukkit.ChatColor;
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
			String bottomBlock = plugin.getConfig().getString("BOTTOM_BLOCK").toUpperCase();
			String topBlock = plugin.getConfig().getString("TOP_BLOCK").toUpperCase();
			Double angle = plugin.getConfig().getDouble("ANGLE");
			String Sound = plugin.getConfig().getString("Sound");
			Sound = Sound.toUpperCase();
			if ((player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.getMaterial(bottomBlock))
					&& (player.getLocation().getBlock().getType() == Material.getMaterial(bottomBlock))) {
				Vector v = player.getLocation().getDirection().multiply(10).setY(angle);
				player.setVelocity(v);
				player.playSound(player.getLocation(), String.valueOf(Sound), 5.0F, 2.0F);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Jump-Message")));
			}
		}
	}
}
