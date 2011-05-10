package com.icomeinpieces.UndroppableDroppables;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Changelog:
 * 1.5 fixed the bug that prevented worldguard from protecting blocks listed in this plugin
 * 1.4 added dropping grass blocks not dirt when grass is broken
 * 1.3 Fixed (hopefully) the spawning water problem and some code clean up.
 * 1.2 Added dropping Ice
 * 1.1 Added dropping Glowstone, Wooden/Cobblestone Stairs, and Glass
 * 1.0 Initial release - supported dropping Bookcases only.
 */

public class UndroppableDroppables extends JavaPlugin{
	public final static Logger log = Logger.getLogger("Minecraft");
	private final UDBlockListener cookies = new UDBlockListener(this);
	private final String pluginName = "UndroppableDroppables v1.5";

	public void onDisable() {
		log.info(pluginName + " Disabled");
	}

	public void onEnable() {
		log.info(pluginName + " Enabled");
		PluginManager pm = getServer().getPluginManager();
    	pm.registerEvent(Event.Type.BLOCK_BREAK, this.cookies, Event.Priority.Normal, this);
	}

}
