package com.gildedrose

class AgedBrie(override val item: Item) : GildedRoseItem {
    override fun update() {
        increaseQuality()
        item.sellIn--
        if (item.sellIn < 0) increaseQuality()
    }

    private fun increaseQuality() {
        if (item.quality < 50) item.quality++
    }
}
