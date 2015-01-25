package com.scape06.fishing;

import org.rev317.min.api.wrappers.Tile;

import com.scape06.misc.Zone;

public class MainData {
	public static boolean fish = false;
	public static boolean fishing = false;
	public static boolean bank = false;
	public static boolean start = false;
	public static boolean powerFish = false;
	public static String strType = "";
	public static String status;
	public static String strMode = "";
	public static int spotId = 0;
	public static int[] fishIds;
	public static int toolId;
	public static int startXp;
	public static int interact;
	public static int xp, catches, currXp;
	public static final Zone BANK_ZONE = new Zone(new Tile(2806, 3443), new Tile(2812, 3438));
	public static final Zone FISH_ZONE = new Zone(new Tile(2835, 3435), new Tile(2843, 3431));
	public final static Tile[] BANK_TO_SPOT = { new Tile(2809, 3439),
			new Tile(2814, 3436), new Tile(2824, 3437), new Tile(2836, 3434) };
}