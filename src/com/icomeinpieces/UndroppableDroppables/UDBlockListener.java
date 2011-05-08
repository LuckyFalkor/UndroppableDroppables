package com.icomeinpieces.UndroppableDroppables;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class UDBlockListener extends BlockListener{
	
	public static UndroppableDroppables plugin;
	public UDBlockListener(UndroppableDroppables instance)
	{
	    plugin = instance;
	}
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.getBlock().getTypeId() == 47)
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(47, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 53)
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(53, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 67)
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(67, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 89)
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(89, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 20)
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(20, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 79)
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(79, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 8)
		{
			event.getBlock().setType(Material.AIR);
		}
	}
}
