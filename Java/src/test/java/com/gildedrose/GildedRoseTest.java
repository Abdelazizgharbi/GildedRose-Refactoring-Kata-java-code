package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	/**
	 * Simpte test to get certain of the item inserted
	 */
	@Test
	public void firstTest() {
		Item[] items = new Item[] { new Item(Utils.backStage, 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(Utils.backStage, app.items[0].name);
	}

	/**
	 * To test the case when items are before sell date 
	 */
	@Test
	public void testBeforeSellDate() {
		Item[] items = new Item[] { new Item(Utils.agedBrie, 2, 2), new Item(Utils.sulfuras, -1, 80),
				new Item(Utils.backStage, 15, 20), new Item(Utils.backStage, 9, 20), new Item(Utils.backStage, 4, 20),
				new Item(Utils.dexteriry, 3, 2), new Item(Utils.conjured, 3, 2) };

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
		Item[] items = new Item[] { new Item(Utils.agedBrie, 0, 2), new Item(Utils.sulfuras, -1, 80),
				new Item(Utils.backStage, 0, 2), new Item(Utils.dexteriry, 0, 3), new Item(Utils.conjured, 0, 2) };

		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(app.items[0].quality, 4);
		assertEquals(app.items[1].quality, 80);
		assertEquals(app.items[2].quality, 0);
		assertEquals(app.items[3].quality, 1);
		assertEquals(app.items[4].quality, 0);
	}

}
