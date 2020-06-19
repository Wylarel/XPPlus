package com.wylarel.xpplus.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import com.wylarel.xpplus.Main;
import com.wylarel.xpplus.utils.Utils;

public class OneClickBottles implements Listener {
	private Main main;

	public OneClickBottles(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onProjectileThrownEvent(ProjectileLaunchEvent event) {
		if(event.getEntity() instanceof ThrownExpBottle && main.getConfig().getBoolean("oneclickbottles.enabled")) {
			ThrownExpBottle entity = (ThrownExpBottle)event.getEntity();
			Player player = (Player) entity.getShooter();
			if(player.isSneaking() && player.hasPermission("oneclickbottles.use"))
			{
				event.setCancelled(true);
				int amount = getAmount(player, new ItemStack(Material.EXPERIENCE_BOTTLE));
				player.sendMessage(Utils.chat(main.getConfig().getString("oneclickbottles.message").replace("<bottles>", Integer.toString(amount))));
				player.playSound(player.getLocation(), Sound.ENTITY_SPLASH_POTION_BREAK, 0.4f, 0.7f);
				Location pos = player.getLocation();
				player.getWorld().spawnParticle(Particle.WATER_SPLASH, pos.getX(), pos.getY()+0.7, pos.getZ(), 100);
				player.giveExp(Math.round(amount * 6.5f));
				/*player.getInventory().remove(Material.EXPERIENCE_BOTTLE);
				if(player.getInventory().getItemInMainHand().getType() == Material.EXPERIENCE_BOTTLE)
				{
					player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
					player.sendMessage("Hey");
				}
				if(player.getInventory().getItemInOffHand().getType() == Material.EXPERIENCE_BOTTLE)player.getInventory().setItemInOffHand(new ItemStack(Material.AIR));*/
				deleteAll(player, new ItemStack(Material.EXPERIENCE_BOTTLE));
				player.updateInventory();
			}
		}
    }
	
	public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }
	
	public static void deleteAll(Player arg0, ItemStack arg1) {
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot != null & slot.isSimilar(arg1))
            	slot.setAmount(0);
        }
    }
}
