package com.scape06.fishing;

public enum FishingData {
	
	SHRIMP(0, 316, 304, new int[] { 318 }, 1), 
	LOBSTER(0, 312, 302, new int[] { 378 }, 40), 
	SWORDFISH(2, 312, 312, new int[] { 372 }, 50),  
	SHARK(2, 313, 312, new int[] { 384 }, 76);
	
	private int interact;
	private int spotId;
	private int toolId;
	private int[] fishIds;
	private int levelReq;

	FishingData(int interact, int spotId, int toolId, int[] fishIds,
			int levelReq) {
		this.interact = interact;
		this.spotId = spotId;
		this.toolId = toolId;
		this.fishIds = fishIds;
		this.levelReq = levelReq;
	}

	public int getInteract() {
		return interact;
	}

	public int getSpotId() {
		return spotId;
	}

	public int getToolId() {
		return toolId;
	}

	public int[] getFishIds() {
		return fishIds;
	}

	public int gerLevelReq() {
		return levelReq;
	}
}