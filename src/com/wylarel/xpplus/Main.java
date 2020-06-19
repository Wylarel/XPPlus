package com.wylarel.xpplus;

import org.bukkit.plugin.java.JavaPlugin;

import com.wylarel.xpplus.commands.ClearXP;
import com.wylarel.xpplus.commands.XPSignCommand;
import com.wylarel.xpplus.listeners.XPSign;
import com.wylarel.xpplus.listeners.OneClickBottles;
import com.wylarel.xpplus.commands.BottleXP;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		System.out.println("XPPlus started");
		getCommand("bottlexp").setExecutor(new BottleXP(this));
		getCommand("clearxp").setExecutor(new ClearXP(this));
		getCommand("xpsign").setExecutor(new XPSignCommand(this));
		getServer().getPluginManager().registerEvents(new OneClickBottles(this), this);
		getServer().getPluginManager().registerEvents(new XPSign(this), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("XPPlus stopped");
	}
}
	