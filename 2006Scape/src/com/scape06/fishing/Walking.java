package com.scape06.fishing;


import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Tile;
import org.rev317.min.api.wrappers.TilePath;

public class Walking implements Strategy {
	
	@Override
	public boolean activate() {
		if (!MainData.powerFish) {
			if (!Inventory.isFull() && Inventory.containts(MainData.toolId)
					&& MainData.BANK_ZONE.inTheZone()) {
				return true;
			} else if (Inventory.isFull()
					&& !MainData.BANK_ZONE.inTheZone()) {
				return true;
			} else {
				return false;
			}
		} else {
			if (!Inventory.isFull()
					&& MainData.BANK_ZONE.inTheZone()) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void execute() {
		MainData.status = "Walking";
		if (!Inventory.isFull()) {
			new Tile(2819, 3437).walkTo();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation().equals(
							new Tile(2833, 3463));
				}
			}, 3000);
			new Tile(2824, 3437).walkTo();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation().equals(
							new Tile(2824, 3437));
				}
			}, 3000);
			new Tile(2836, 3434).walkTo();
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getLocation().equals(
							new Tile(2836, 3434));
				}
			}, 3000);
			if (MainData.spotId == FishingData.SHARK.getSpotId()) {
				new Tile(2852, 3428).walkTo();
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getLocation().equals(
								new Tile(2852, 3428));
					}
				}, 3000);
			}
		}
		if (Inventory.isFull()) {
			TilePath path = new TilePath(MainData.BANK_TO_SPOT).reverse();
			if (path != null) {
				path.traverse();
				Time.sleep(1000);
			}
		}
		Time.sleep(80);
	}
}