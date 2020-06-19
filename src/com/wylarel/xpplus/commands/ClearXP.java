package com.wylarel.xpplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.wylarel.xpplus.Main;
import com.wylarel.xpplus.utils.Utils;

public class ClearXP implements CommandExecutor {
	private Main main;

	public ClearXP(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player)sender;
			Player target = p;
			if(args.length != 0 && p.hasPermission("clearxp.use"))
			{
				target = Bukkit.getPlayer(args[0]);
				if(target.getExp() == 0 && target.getLevel() == 0)
					target.sendMessage(Utils.chat(main.getConfig().getString("clearxp.other.error.already_null").replace("<player>", target.getDisplayName())));
				else
					target.sendMessage(Utils.chat(main.getConfig().getString("clearxp.other.message").replace("<player>", target.getDisplayName())));
			}
			else
			{
				if(target.getExp() == 0 && target.getLevel() == 0)
					target.sendMessage(Utils.chat(main.getConfig().getString("clearxp.self.error.already_null")));
				else
					target.sendMessage(Utils.chat(main.getConfig().getString("clearxp.self.message")));
			}
			target.setExp(0);
			target.setLevel(0);
		}
		else
		{
			sender.sendMessage("§cThis command can only be used by a player client");
		}
		return true;
	}
}
