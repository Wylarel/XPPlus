package com.wylarel.xpplus.listeners;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.wylarel.xpplus.Main;
import com.wylarel.xpplus.commands.BottleXP;

public class XPSign implements Listener {
	private Main main;

	public XPSign(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
		if (e.getClickedBlock() == null) return;
		else if (e.getClickedBlock().getType().name().contains("SIGN") && p.hasPermission("xpsign.use"))
		{
			Block block = e.getClickedBlock();
			
			String loc = block.getLocation().toString();
			List<String> list = main.getConfig().getStringList("xpsign.list");
			if(list.contains(loc))
			{
				BottleXP.onBottleXP(main, p);
			}
		}
	}
}
