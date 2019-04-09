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

			if (!items[i].name.equals(Utils.sulfuras)) {
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
	 * @param item
	 */
	public void caseBeforeDate(Item item) {

		if (item.name.equals(Utils.backStage)) {
			increase(item);
			if (item.sellIn < 11) {
				increase(item);
			}
			if (item.sellIn < 6) {
				 increase(item);
			}
		} else if (item.name.equals(Utils.agedBrie)) {
			increase(item);
		} else {
			decrease(item);
		}
		// case when conjured item
		if (item.name.equals(Utils.conjured)) {
			decrease(item);
		}
	}

	/**
	 *  To handle the case when the Sell date passed
	 * @param item
	 */
	public void caseAfterDate(Item item) {

		if (item.name.equals(Utils.backStage)) {
			item.quality = 0;
		} else if (item.name.equals(Utils.agedBrie)) {
			 increase(item);
		} else {
			 decrease(item);
		}
		// case when conjured item
		if (item.name.equals(Utils.conjured)) {
			decrease(item);
		}
	}

	/**
	 * decrease quality
	 * 
	 * @param item
	 * @return
	 */
	public void decrease(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	/**
	 * increase quality
	 * 
	 * @param item
	 * @return
	 */
	public void increase(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}