package com.icomeinpieces.UndroppableDroppables;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
//import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class UDBlockListener extends BlockListener
{
	public UndroppableDroppables UDP;
	private UDEntityListener EDEL;
	public UDblockWatcher UDBW = new UDblockWatcher(this);
	private int spamController=200;

    Player player;
    Block block;
	public UDBlockListener(UndroppableDroppables instance, UDEntityListener udEntityListner)
	{
	    UDP = instance;
	    EDEL = udEntityListner;
	}
	
	public void onBlockBreak(BlockBreakEvent event) 
	{
		if (!event.isCancelled())
		{
			player = event.getPlayer();
			block = event.getBlock();
			EDEL.locale=null;
			EDEL.material=null;
			EDEL.itemCount=0;
			if (checkWG(player, block) && checkPB(player))
			{
				if (block.getTypeId() == 47 && checkDrop("ud.drop.bookcase")) //bookcases drop bookcases not nothing
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.bookshelfDrop)
			        {
				        case 1:
				        {
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(47, 1, (short) 1));
				        	break;
				        }
				        case 2:
				        {
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(340, 3));
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(5, 6));
				        	break;
				        }
			        }
				}
				if (block.getTypeId() == 53 && checkDrop("ud.drop.woodenstairs")) //wooden stairs drops wooden stairs not wood
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.woodenstairsDrop)
			        {
				        case 1:
				        {
				            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
				        case 2:
				        {
                            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
			        }
				}
				if (block.getTypeId() == 67 && checkDrop("ud.drop.cobblestonestairs")) // stone stairs drops stone stairs not cobblestone
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.cobblestonestairsDrop)
			        {
				        case 1:
				        {
                            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
				        case 2:
				        {
                            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
			        }
				}
				if (block.getTypeId() == 89 && checkDrop("ud.drop.glowstone")) //glowstone drops glowstone not dust
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.glowstoneDrop)
			        {
				        case 1:
				        {
                            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
				        case 2:
				        {
				            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
			        }
				}
				if (block.getTypeId() == 20 && checkDrop("ud.drop.glass")) //glass drops glass not nothing
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.glassDrop)
			        {
				        case 1:
				        {
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(20, 1));
				        	break;
				        }
				        case 2:
				        {
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(12, 1));
				        	break;
				        }
			        }
				}
				if (block.getTypeId() == 79 && checkDrop("ud.drop.ice")) //ice drops ice not water in it's place
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.iceDrop)
			        {
				        case 1:
				        {
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(79, 1));
				        	UDBW.setLocation(locale);
							UDBW.setCheck(true);
							Thread t = new Thread(UDBW);
							t.start();
				        	break;
				        }
				        case 2:
				        {
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(79, 1));
				        	break;
				        }
			        }
				}
				if (block.getTypeId() == 2 && checkDrop("ud.drop.grass")) //grass drops grass not dirt
				{
			        Location locale = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0.0F, 0.0F);
			        switch (UDP.grassDrop)
			        {
			            case 0:
			            {
                            EDEL.material = null;
                            break;
			            }
				        case 1:
				        {
                            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	break;
				        }
				        case 2:
				        {
				            EDEL.material = block.getType();
                            EDEL.locale=locale;
				        	event.getBlock().getWorld().dropItem(locale, new ItemStack(295, 1));
				        	break;
				        }
			        }
				}	    
			}
		}
		player = null;
		block = null;
	}

	@SuppressWarnings("deprecation")
    private boolean checkPB(Player player)
	{
		World world = player.getWorld();
		if (UDP.permissionHandler != null)
		{
		    
			//String playerGroup = UDP.permissionHandler.getGroup(world.getName(), player.getName());
			//if (UDP.permissionHandler.canGroupBuild(world.getName(), playerGroup))
			try
            {
                if (UDP.permissionHandler.canUserBuild(world.getName(), player.getName()))    
                {
                	return true;
                }
                else
                {
                	return false;
                }
            }
            catch (NoSuchMethodError e)
            {
                if (spamController >= 200)
                {
                    UDP.log.info("you seem to be using an outdated version of permissions (namely pre 3.x) please update for better preformance");
                    UDP.log.info("this message will repeat with every 200 blocks broken");
                    spamController =0;
                }
                else
                {
                    spamController++;
                }
                String playerGroup = UDP.permissionHandler.getGroup(world.getName(), player.getName());
                if (UDP.permissionHandler.canGroupBuild(world.getName(), playerGroup))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
		}
		else
		{
			return true;
		}
	}
	
	private boolean checkDrop(String permissionNode)
	{
	    if (UDP.permissionsEnabaled)
	    {
	        return (UDP).permissionHandler.has(player, permissionNode);
	    }
	    else
	    {
	        return true;
	    }
	}
	
	private boolean checkWG(Player player, Block block)
	{
		if (UndroppableDroppables.WGP != null)
		{
			if (UndroppableDroppables.WGP.canBuild(player, block))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
}
