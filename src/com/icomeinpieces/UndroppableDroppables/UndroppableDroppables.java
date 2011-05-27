package com.icomeinpieces.UndroppableDroppables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

/*
 * Changelog:
 * 1.09 added a config file for additional configurations
 * 1.08 fixed the bug preventing UndroppableDroppables from starting if WorldGuard or Permissions were not present
 * 1.07 added checks to disable plugin in the event the required permissions and worldedit are not present
 * 1.06 Introduced permissions integration so that UndroppableDroppable listed blocks are now properly protected via he build permisions
 * 1.05 introduced worldguard integration so that UndroppableDroppable listed blocks are now properly protected via regions.
 * 1.04 added dropping grass blocks not dirt when grass is broken
 * 1.03 Fixed (hopefully) the spawning water problem and some code clean up.
 * 1.02 Added dropping Ice
 * 1.01 Added dropping Glowstone, Wooden/Cobblestone Stairs, and Glass
 * 1.0 Initial release - supported dropping Bookcases only.
 */

public class UndroppableDroppables extends JavaPlugin{
	public final static Logger log = Logger.getLogger("Minecraft");
	private final UDBlockListener udBlocklistner = new UDBlockListener(this);
	public static WorldGuardPlugin WGP;
	public static PermissionHandler permissionHandler;
	private PluginManager pm;
	private final String pluginName = "UndroppableDroppables v1.09";
	private String filePath = "/UndroppableDroppables.cfg";
	
	public static int bookshelfDrop=1;
	public static int glowstoneDrop=1;
	public static int woodenstairsDrop=1;
	public static int cobblestonestairsDrop=1;
	public static int glassDrop=1;
	public static int iceDrop=1;
	public static int grassDrop=1;

	public void onDisable() {
		log.info(pluginName + " Disabled");
		writeConfigFile();
	}

	public void onEnable() {
		log.info(pluginName + " Starting");
		setupWorldGuard();
		setupPermissions();
		pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_BREAK, this.udBlocklistner, Event.Priority.Highest, this);
		onReload();
		log.info(pluginName + " Enabled");
	}
	
	public void onReload()
	{
		File configFile = new File(getDataFolder()+ filePath);
		if (configFile.exists())
	    {
			Properties config = new Properties();
	        try
	        {
	        FileInputStream in = new FileInputStream(configFile);
	        config.load(in);
	        bookshelfDrop = Integer.parseInt(config.getProperty("bookshelf"));
	        if (bookshelfDrop!=0 && bookshelfDrop!=1 && bookshelfDrop!=2) bookshelfDrop=1;
	        glowstoneDrop = Integer.parseInt(config.getProperty("glowstone"));
	        if (glowstoneDrop!=0 && glowstoneDrop!=1 && glowstoneDrop!=2) glowstoneDrop=1;
	        woodenstairsDrop = Integer.parseInt(config.getProperty("wooden_stairs"));
	        if (woodenstairsDrop!=0 && woodenstairsDrop!=1 && woodenstairsDrop!=2) woodenstairsDrop=1;
	        cobblestonestairsDrop = Integer.parseInt(config.getProperty("cobblestone_stairs"));
	        if (cobblestonestairsDrop!=0 && cobblestonestairsDrop!=1 && cobblestonestairsDrop!=2)  cobblestonestairsDrop=1;
	        glassDrop = Integer.parseInt(config.getProperty("glass"));
	        if (glassDrop!=0 && glassDrop!=1 && glassDrop!=2) glassDrop=1;
	        iceDrop = Integer.parseInt(config.getProperty("ice"));
	        if (iceDrop!=0 && iceDrop!=1 && iceDrop!=2) iceDrop=1;
	        grassDrop = Integer.parseInt(config.getProperty("grass"));
	        if (grassDrop!=0 && grassDrop!=1 && grassDrop!=2) grassDrop=1;
	        }
	        catch (IOException e)
	        {
	        	log.warning(pluginName + " unable to read the config file, restoring to defaults");
	        	writeConfigFile();
	        }
	     }
	     else
	     {
	    	 log.warning(pluginName + " config file does not exist, ignore this if this is the first start. writing config file");
	    	 writeConfigFile();
	     }
	}
	
	private void writeConfigFile()
	{
		File configFile = new File(getDataFolder()+ filePath);
		File dir = new File(getDataFolder().toString());
	     if (!dir.exists())
	     {
	    	 dir.mkdir();
	    	 log.info(pluginName + " data directory created");
	     }
	     if (configFile.exists())
	     {
	    	 configFile.delete();
	     }
	     try
	     {
	    	 configFile.createNewFile();
	         try
	         {
	        	 PrintWriter out = new PrintWriter(new FileWriter(getDataFolder()+filePath));
	        	 out.println("#set to option 0 for any one option to disable plugin function for that block");
	        	 out.println("#set to option 1 for " + pluginName + " based behaviour");
	        	 out.println("#set to option 2 for special behaviour, commonly the return of the resources that made a given block");
	        	 out.println("#");
	        	 out.println("#option 2 gives back 6 wooden planks and 3 books");
		         out.println("bookshelf="+bookshelfDrop);
		         out.println("#option 2 gives back 9 glowstone dust");
		         out.println("glowstone="+glowstoneDrop);
		         out.println("#option 2 gives back 6 wooden planks");
		         out.println("wooden_stairs="+woodenstairsDrop);
		         out.println("#option 2 gives back 6 cobblestone");
		         out.println("cobblestone_stairs="+cobblestonestairsDrop);
		         out.println("#option 2 gives back one sand");
		         out.println("glass="+glassDrop);
		         out.println("#option 2 gives an ice block and allows water to spawn from the ice block normally");
		         out.println("ice="+iceDrop);
		         out.println("#option 2 gives seeds (just for fun), since grass is not built or crafted");
		         out.println("grass="+grassDrop);
		         out.close();
		    	 log.info(pluginName + " config file written to " + filePath);
	         }
	                catch (IOException e)
	         {
	                	log.warning(pluginName + " unable to write to file at " + filePath);
	         }
	     }
	     catch(IOException ioe)
	     {
	    	 log.warning(pluginName + " unable to create config file");
	     }
	}
	
	private boolean setupPermissions() {
	      Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

	      if (UndroppableDroppables.permissionHandler == null) {
	          if (permissionsPlugin != null) {
	              UndroppableDroppables.permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	              log.info(pluginName + ": Permission system detected");
	              return true;
	          } else {
	              log.info(pluginName + ": Permission system not detected");
	              return true;
	          }
	      }
	      log.info("critical error in detecting Permissions. please advise author");
		return false;
	  }
	 private boolean setupWorldGuard() {
	      Plugin WorldGuardPlugin = this.getServer().getPluginManager().getPlugin("WorldGuard");

	      if (UndroppableDroppables.WGP == null) {
	          if (WorldGuardPlugin != null) {
	              log.info(pluginName + ": WorldGuard Plugin found");
	              WGP = (WorldGuardPlugin) WorldGuardPlugin;
	              return true;
	          } else {
	              log.info(pluginName + ": WorldGuard not detected");
	              return true;
	          }
	      }
	      log.info("critical error in detecting WorldGuard. please advise author");
		return false;
	  }

}
