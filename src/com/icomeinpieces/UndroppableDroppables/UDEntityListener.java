package com.icomeinpieces.UndroppableDroppables;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class UDEntityListener extends EntityListener
{
    private UndroppableDroppables UDP;
    public Material material;
    public Location locale;
    public int itemCount=0;
    public UDEntityListener(UndroppableDroppables instance)
    {
        UDP = instance;
    }
    @Override
    public void onItemSpawn(ItemSpawnEvent event)
    {
        if (locale != null && event.getEntity() instanceof Item)
        {
            Item item = (Item) event.getEntity();
            if (locationMatch(locale, item) && blockMatch(material, item))
            {
                event.setCancelled(true);
            }
            else
            {
                material =null;
            }
        }
    }
    private boolean blockMatch(Material block2Check, Item item2Check)
    {
        if (item2Check.getItemStack().getType() == Material.GLOWSTONE_DUST)
        {
            if (UDP.glowstoneDrop==1 && block2Check == Material.GLOWSTONE)
            {
                locale.getWorld().dropItem(locale, new ItemStack(89, 1, (short) 1));
            }
            material = null;
            if (UDP.glowstoneDrop==2 && ++itemCount <=4)
            {
                locale.getWorld().dropItem(locale, new ItemStack(348, 1));
                return false;
            }
            return true;
        }
        if (block2Check == Material.GRASS && item2Check.getItemStack().getType() == Material.DIRT)
        {
            if (UDP.grassDrop == 0)
            {
                return false;
            }
            locale.getWorld().dropItem(locale, new ItemStack(2, 1));
            return true;
        }
        if (block2Check == Material.WOOD_STAIRS && item2Check.getItemStack().getType() == Material.WOOD)
        {
            if (UDP.woodenstairsDrop == 1)
            {
                locale.getWorld().dropItem(locale, new ItemStack(53, 1, (short) 1));
            }
            if (UDP.woodenstairsDrop == 2 && ++itemCount <=6)
            {
                locale.getBlock().getWorld().dropItem(locale, new ItemStack(5, 1));
                return false;
            }
            return true;
        }
        if (block2Check == Material.COBBLESTONE_STAIRS && item2Check.getItemStack().getType() == Material.COBBLESTONE)
        {
            if (UDP.cobblestonestairsDrop == 1)
            {
                locale.getWorld().dropItem(locale, new ItemStack(67, 1, (short) 1));
            }
            if (UDP.cobblestonestairsDrop == 2 && ++itemCount <=6)
            {
                locale.getBlock().getWorld().dropItem(locale, new ItemStack(4, 1));
                return false;
            }
            return true;
        }
        return false;
    }
    private boolean locationMatch(Location block2Check, Item item2Check)
    {
        double x = Math.abs(block2Check.getX() - item2Check.getLocation().getX());
        double y = Math.abs(block2Check.getY() - item2Check.getLocation().getY());
        double z = Math.abs(block2Check.getZ() - item2Check.getLocation().getZ());
        if (x<=1 && y<=1 && z<=1)
        {
            return true;
        }
        return false;
    }
    
}
