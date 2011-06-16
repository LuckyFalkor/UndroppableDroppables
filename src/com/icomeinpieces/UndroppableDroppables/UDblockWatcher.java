package com.icomeinpieces.UndroppableDroppables;

import org.bukkit.Location;

public class UDblockWatcher implements Runnable
{
	private boolean check = true;
	private Location locale = null;
	private UDBlockListener UDBL = null;
	public UDblockWatcher(UDBlockListener udBlockListener)
	{
		UDBL = udBlockListener;
	}

	@Override
	public void run() 
	{
		while(check)
		{
			if (locale != null)
			{
			    locale.getBlock().setTypeId(0);
			    check = false;
			}
			else
			{
			    UDBL.UDP.log.info("something went wrong with block detection, advise author please");
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		locale = null;
	}
	public void setCheck(boolean check)
	{
		this.check = check;
	}

	public void setLocation(Location locale) 
	{
		this.locale = new Location(locale.getWorld(), locale.getX(), locale.getY(), locale.getZ());
	}
}
