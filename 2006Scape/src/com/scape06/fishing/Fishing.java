package com.scape06.fishing;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.Tile;

public class Fishing implements Strategy {

	@Override
	public boolean activate() {
		// Npc spot = getNpc(MainData.spotId);
		/*
		 * for(int i = 0; i < npcs.length; i++){ if(npcs[i]!=null){ spot =
		 * npcs[i]; } }
		 */
		return !Players.getMyPlayer().isInCombat()
				&& (MainData.FISH_ZONE.inTheZone() || 
					Players.getMyPlayer().getLocation().equals(new Tile(2852, 3428)))
				&& Players.getMyPlayer().getAnimation() == -1 &&!Inventory.isFull();
	}

	@Override
	public void execute() {
		MainData.status = "Fishing";
		Npc[] spot = Npcs.getNearest(MainData.spotId);
		if (Players.getMyPlayer().getAnimation() != 621 && spot != null
				&& spot[0].distanceTo() < 6) {
			spot[0].interact(MainData.interact);
			Time.sleep(3000);
		}
		Time.sleep(80);
	}
}
