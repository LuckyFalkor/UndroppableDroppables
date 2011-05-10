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
		int blockInQuestion = event.getBlock().getTypeId();
		if (blockInQuestion == 47) //bookcases drop bookcases not nothing
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (blockInQuestion == 53) //wooden stairs drops wooden stairs not wood
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (blockInQuestion == 67) // stone stairs drops stone stairs not cobblestone
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (blockInQuestion == 89) //glowstone drops glowstone not dust
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (blockInQuestion == 20) //glass drops glass not nothing
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (blockInQuestion == 79) //ice drops ice not water in it's place
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (blockInQuestion == 2) //grass drops grass not dirt add occasional seeds?
		{
	        Location locy = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
	        if (event.getBlock().getTypeId() != blockInQuestion)
	        {
	        	event.getBlock().getWorld().dropItem(locy, new ItemStack(blockInQuestion, 1, (short) 1));
	        }
		}
		if (event.getBlock().getTypeId() == 8) //handles the water that generates after an ice block is broken
		{
			event.getBlock().setType(Material.AIR);
		}
	}
}
