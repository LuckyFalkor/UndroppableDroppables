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
		if (event.getBlock().getTypeId() == 47) //bookcases drop bookcases not nothing
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(47, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 53) //wooden stairs drops wooden stairs not wood
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(53, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 67) // stone stairs drops stone stairs not cobblestone
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(67, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 89) //glowstone drops glowstone not dust
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(89, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 20) //glass drops glass not nothing
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(20, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 79) //ice drops ice not water in it's place
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(79, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 2) //grass drops grass not dirt add occasional seeds?
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        event.getBlock().getWorld().dropItem(locy, new ItemStack(2, 1, (short) 1));
	        event.getBlock().setType(Material.AIR);
	        event.setCancelled(true);
		}
		if (event.getBlock().getTypeId() == 8) //handles the water that generates after an ice block is broken
		{
			event.getBlock().setType(Material.AIR);
		}
	}
}
