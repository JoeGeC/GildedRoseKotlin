package com.gildedrose
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GildedRoseTest {
    private val generalItemName = "A general item"
    private val brieItemName = "Aged Brie"
    private val sulfurasItemName = "Sulfuras, Hand of Ragnaros"
    private val backstageItemName = "Backstage passes to a TAFKAL80ETC concert"

    @Test
    fun `Item sell by date decreases`() {
        val app = runGildedRose(arrayOf(Item(generalItemName, 8, 10)))
        itemHasExpectedSellIn(app.items[0], 7)
    }
    @Test fun `Item degrades in quality`() {
        val app = runGildedRose(arrayOf(Item(generalItemName, 7, 22)))
        itemHasExpectedQuality(app.items[0], 21)
    }
    @Test fun `Item degrades twice as fast when sell by date past`() {
        val app = runGildedRose(arrayOf(Item(generalItemName, 0, 10)))
        itemHasExpectedQuality(app.items[0], 8)
    }
    @Test fun `Item quality is never negative`() {
        val app = runGildedRose(arrayOf(Item(generalItemName, 6, 0)))
        itemHasExpectedQuality(app.items[0], 0)
    }
    @Test fun `Aged Brie increases in quality as it gets older`() {
        val app = runGildedRose(arrayOf(Item(brieItemName, 5, 10)))
        itemHasExpectedQuality(app.items[0], 11)
    }
    @Test fun `Aged brie increases in quality when sell by date past`() {
        val app = runGildedRose(arrayOf(Item(brieItemName, 0, 0)))
        itemHasExpectedQuality(app.items[0], 2)
    }
    @Test fun `Quality of an item is never more than 50`() {
        val app = runGildedRose(arrayOf(Item(brieItemName, 5, 50)))
        itemHasExpectedQuality(app.items[0], 50)
    }
    @Test fun `Sulfuras never decreases in quality`() {
        val app = runGildedRose(arrayOf(Item(sulfurasItemName, 5, 10)))
        itemHasExpectedQuality(app.items[0], 10)
    }
    @Test fun `Backstage passes increase in quality by 2 when 6 to 10 days sell in remaining`() {
        val app = runGildedRose(arrayOf(Item(backstageItemName, 8, 25)))
        itemHasExpectedQuality(app.items[0], 27)
    }
    @Test fun `Backstage passes increase in quality by 3 when 5 or less days sell in remaining`() {
        val app = runGildedRose(arrayOf(Item(backstageItemName, 3, 43)))
        itemHasExpectedQuality(app.items[0], 46)
    }
    @Test fun `Backstage passes quality does not exceed 50 when 5 or less days sell in remaining`() {
        val app = runGildedRose(arrayOf(Item(backstageItemName, 2, 48)))
        itemHasExpectedQuality(app.items[0], 50)
    }
    @Test fun `Backstage passes quality is 0 when sell is less than 0`() {
        val app = runGildedRose(arrayOf(Item(backstageItemName, 0, 25)))
        itemHasExpectedQuality(app.items[0], 0)
    }
    private fun runGildedRose(items: Array<Item>): GildedRose {
        val app = GildedRose(items)
        app.updateQuality()
        return app
    }
    private fun itemHasExpectedQuality(item: Item, quality: Int) {
        assertEquals(quality, item.quality)
    }
    private fun itemHasExpectedSellIn(item: Item, sellIn: Int) {
        assertEquals(sellIn, item.sellIn)
    }
}

