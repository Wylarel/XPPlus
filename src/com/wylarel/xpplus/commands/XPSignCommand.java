package com.wylarel.xpplus.commands;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.wylarel.xpplus.Main;
import com.wylarel.xpplus.utils.Utils;

public class XPSignCommand implements CommandExecutor {
	private Main main;

	public XPSignCommand(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			Block block = p.getTargetBlock(null, 100);
			if(block == null)
			{
				sender.sendMessage("§cYou must be pointing to a sign to use this command");
				return false;
			}
			else if(block.getType().name().contains("SIGN"))
			{
				String loc = block.getLocation().toString();
				List<String> list = main.getConfig().getStringList("xpsign.list");
				if(list.contains(loc))
				{
					list.remove(loc);
					main.getConfig().set("xpsign.list", list);
					main.saveConfig();
					p.sendMessage(Utils.chat(main.getConfig().getString("xpsign.onremove").replace("<sign>", block.getType().name()).replace("<location>", block.getLocation().toString())));
				
				} else
				{
					list.add(loc);
					main.getConfig().set("xpsign.list", list);
					main.saveConfig();
					p.sendMessage(Utils.chat(main.getConfig().getString("xpsign.oncreate").replace("<sign>", block.getType().name()).replace("<location>", block.getLocation().toString())));
				}
			}
			else
			{
				sender.sendMessage("§cThis command can only target signs. Your are pointing to a §4" + block.getType().name() + " §cblock");
			}
		}
		else
		{
			sender.sendMessage("§cThis command can only be used by a player client");
		}
		return true;
	}
}
