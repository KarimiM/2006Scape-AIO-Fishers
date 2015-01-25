package com.scape06.fishing;

import java.util.ArrayList;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Item;

public class Dropping implements Strategy {
	@Override
	public boolean activate() {
		return !Players.getMyPlayer().isInCombat() && Inventory.isFull()
				&& MainData.powerFish;
	}

	@Override
	public void execute() {
		System.out.println("Dropping Fish");
		MainData.status = "Dropping fish";
		dropAllExcept(MainData.toolId);
		Time.sleep(1000);
	}

	//Drop All Except
	private static void dropAllExcept(int... itemIDs) {
		final ArrayList<Integer> dontDrop = new ArrayList<>();
		if (Inventory.getCount(false) <= 2) {
			return;
		} else {
			for (int i : itemIDs) {
				dontDrop.add(i);
			}
		}
		for (Item inventoryItem : Inventory.getItems()) {
			if (!dontDrop.contains(inventoryItem.getId())) {
				Menu.sendAction(847, inventoryItem.getId() - 1,
						inventoryItem.getSlot(), 3214);
				Time.sleep(80);
			}
		}
	}
}