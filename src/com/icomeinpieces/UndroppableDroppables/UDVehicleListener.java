package com.icomeinpieces.UndroppableDroppables;

import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleListener;
import org.bukkit.inventory.ItemStack;

public class UDVehicleListener extends VehicleListener
{
	public static UndroppableDroppables UDP;
	public UDVehicleListener(UndroppableDroppables instance)
	{
	    UDP = instance;
	}

	public void onVehicleDestroy(VehicleDestroyEvent event)
	{
		if (!event.isCancelled())
		{
			Player player = null;
			if (event.getAttacker() instanceof Player) 
			{
				player = (Player) event.getAttacker();
			}
			else
			{
				UDP.log.info("UDP event trigger: non player attacker");
			}
			if (event.getVehicle() instanceof Boat && player!=null &&(UDP).permissionHandler.has(player, "ud.drop.boat"))
			{
				Location locale = new Location(event.getVehicle().getWorld(), event.getVehicle().getLocation().getX(), event.getVehicle().getLocation().getY(), event.getVehicle().getLocation().getZ(), 0.0F, 0.0F);
				if (!event.getVehicle().isEmpty())
				{
					event.getVehicle().getPassenger().eject();
				}
				event.getVehicle().remove();
				switch (UDP.boatDrop)
				{
					case 0:
					{
						event.getVehicle().getWorld().dropItem(locale, new ItemStack(280, 2));
						event.getVehicle().getWorld().dropItem(locale, new ItemStack(5, 3));
						break;
					}
					case 1:
					{
						event.getVehicle().getWorld().dropItem(locale, new ItemStack(333, 1));
						break;
					}
					case 2:
					{
						event.getVehicle().getWorld().dropItem(locale, new ItemStack(5, 5));
						break;
					}
				}
				event.setCancelled(true);
			}
		}
	}
}
