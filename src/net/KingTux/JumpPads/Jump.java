package net.KingTux.JumpPads;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Jump implements Listener {
	private Jumpads plugin;

	public Jump(Jumpads pl) {
		plugin = pl;
	}

	@EventHandler
	public void Event(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		String BB = plugin.getConfig().getString("BOTTOM_BLOCK");
		String TB = plugin.getConfig().getString("TOP_BLOCK");
		Double angle = plugin.getConfig().getDouble("ANGLE");
		String Sound = plugin.getConfig().getString("Sound");
		Sound = Sound.toUpperCase();
		TB = TB.toUpperCase();
		BB = BB.toUpperCase();
		if ((player.getLocation().subtract(0, 1, 0).getBlock().getType() == Material.getMaterial(BB))
				&& (player.getLocation().getBlock().getType() == Material.getMaterial(TB))) {
			Vector v = player.getLocation().getDirection().multiply(10).setY(angle);
			player.setVelocity(v);
			player.playSound(player.getLocation(), Sound.valueOf(Sound), 5.0F, 2.0F);
				
		}
	}
}
