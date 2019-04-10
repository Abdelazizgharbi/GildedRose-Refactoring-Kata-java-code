package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	/**
	 * Simpte test to get certain of the item inserted
	 */
	@Test
	public void firstTest() {
		Item[] items = new Item[] { new Item(Utils.BackStageItem, 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(Utils.BackStageItem, app.items[0].name);
	}

	/**
	 * To test the case when items are before sell date 
	 */
	@Test
	public void testBeforeSellDate() {
		Item[] items = new Item[] { new Item(Utils.AgedBrieItem, 2, 2), new Item(Utils.SulfurasItem, -1, 80),
				new Item(Utils.BackStageItem, 15, 20), new Item(Utils.BackStageItem, 9, 20), new Item(Utils.BackStageItem, 4, 20),
				new Item(Utils.DexteriryItem, 3, 2), new Item(Utils.ConjuredItem, 3, 2) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(app.items[0].quality, 3);
		assertEquals(app.items[1].quality, 80);
		assertEquals(app.items[2].quality, 21);
		assertEquals(app.items[3].quality, 22);
		assertEquals(app.items[4].quality, 23);
		assertEquals(app.items[5].quality, 1);
		assertEquals(app.items[6].quality, 0);

	}
	
	/**
	 * To test the case when items are after sell date 
	 */
	@Test
	public void testAfterSellDate() {
		Item[] items = new Item[] { new Item(Utils.AgedBrieItem, 0, 2), new Item(Utils.SulfurasItem, -1, 80),
				new Item(Utils.BackStageItem, 0, 2), new Item(Utils.DexteriryItem, 0, 3), new Item(Utils.ConjuredItem, 0, 2) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(app.items[0].quality, 4);
		assertEquals(app.items[1].quality, 80);
		assertEquals(app.items[2].quality, 0);
		assertEquals(app.items[3].quality, 1);
		assertEquals(app.items[4].quality, 0);
	}

}
