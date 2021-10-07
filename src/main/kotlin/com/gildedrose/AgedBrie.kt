package com.gildedrose

class AgedBrie(override val item: Item) : GildedRoseItem {
    override fun update() {
        item.increaseQuality()
        item.decreaseSellIn()
        item.increaseQualityIfOutOfDate()
    }
}
