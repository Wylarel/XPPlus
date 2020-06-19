package com.wylarel.xpplus.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.wylarel.xpplus.utils.Utils;
import com.wylarel.xpplus.Main;

public class BottleXP implements CommandExecutor {
	
	private Main main;

	public BottleXP(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player)
		{
			return onBottleXP(main, (Player)sender);
		}
		else
		{
			sender.sendMessage("§cThis command can only be used by a player client");
		}
		return true;
	}
	public static boolean onBottleXP(Main main, Player p) 
	{
		int level = p.getLevel();
		int newLevel = 0;
		int bottles = 0;
		
		switch (main.getConfig().getInt("bottlexp.type")) {
		case 0:
			float multLevel = level * (float)main.getConfig().getDouble("bottlexp.ratio");
			if(multLevel <= 17)
			{
				bottles = (int) Math.round((Math.pow((double)multLevel, 2) + 6 * multLevel) / 6.5f);
			}
			else if(multLevel <= 31)
			{
				bottles = (int) Math.round((2.5f * Math.pow((double)multLevel, 2) - 40.5f * multLevel + 360) / 6.5f);
			}
			else
			{
				bottles = (int) Math.round((4.5f * Math.pow((double)multLevel, 2) - 162.5f * multLevel + 2220) / 6.5f);
			}
			break;
		case 1:
			bottles = Math.round((float)level * (float)main.getConfig().getDouble("bottlexp.ratio"));
			break;
		default:
			break;
		}
		
		if(level > 0)
		{
			p.setLevel(newLevel);
			
			PlayerInventory inventory = p.getInventory();
			ItemStack itemStack = new ItemStack(Material.EXPERIENCE_BOTTLE, bottles);
			inventory.addItem(itemStack);
			
			p.sendMessage(Utils.chat(main.getConfig().getString("bottlexp.message").replace("<bottles>", Integer.toString(bottles)).replace("<levels>", Integer.toString(level))));
		} else
		{
			p.sendMessage(Utils.chat(main.getConfig().getString("bottlexp.error.not_enough")));
		}
		
		return true;
	}
}
