package com.gildedrose;

class GildedRose {

	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	/**
	 * Global method to update items's quality based to date and types
	 */
	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals(Utils.SulfurasItem)) {
				caseBeforeDate(items[i]);
				items[i].sellIn = items[i].sellIn - 1;
				if (items[i].sellIn < 0) {
					caseAfterDate(items[i]);
				}
			}
		}
	}

	/**
	 * To handle the case before the Sell date passed
	 * 
	 * @param item
	 */
	private void caseBeforeDate(Item item) {
		
		switch (item.name) {
		case Utils.BackStageItem:
			increase(item, 50);
			if (item.sellIn < 11) {
				increase(item, 50);
			}
			if (item.sellIn < 6) {
				increase(item, 50);
			}
			break;
		case Utils.AgedBrieItem:
			increase(item, 50);
			break;
		case Utils.ConjuredItem:
			decrease(item, 0);
		default :decrease(item, 0);
		}
	}

	/**
	 * To handle the case when the Sell date passed
	 * 
	 * @param item
	 */
	private void caseAfterDate(Item item) {

		switch (item.name) {
		case Utils.BackStageItem:
			item.quality = 0;
			break;
		case Utils.AgedBrieItem:
			increase(item, 50);
			break;
		case Utils.ConjuredItem:
			decrease(item, 0);
		default :decrease(item, 0);
		}
	}

	/**
	 * decrease quality
	 * 
	 * @param item
	 * @return
	 */
	private void decrease(Item item, int bornInf) {
		if (item.quality > bornInf) {
			item.quality = item.quality - 1;
		}
	}

	/**
	 * increase quality
	 * 
	 * @param item
	 * @return
	 */
	private void increase(Item item, int bornSup) {
		if (item.quality < bornSup) {
			item.quality = item.quality + 1;
		}
	}
}
