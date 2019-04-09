package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {

        Item[] items = new Item[] {
                new Item(Utils.dexteriry, 10, 20), //
                new Item(Utils.agedBrie, 2, 0), //
                new Item(Utils.elexir, 5, 7), //
                new Item(Utils.sulfuras, 0, 80), //
                new Item(Utils.sulfuras, -1, 80),
                new Item(Utils.backStage, 15, 20),
                new Item(Utils.backStage, 10, 49),
                new Item(Utils.backStage, 5, 49),
                new Item(Utils.conjured, 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
