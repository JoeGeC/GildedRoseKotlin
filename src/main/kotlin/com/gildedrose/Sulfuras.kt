package com.gildedrose

class Sulfuras(override val item: Item) : GildedRoseItem {
    override fun update() {
        if (item.sellIn < 0) increaseQuality()
    }

    private fun increaseQuality() {
        if (item.quality < 50) item.quality++
    }
}
