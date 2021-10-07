package com.gildedrose

class GeneralItem(override val item: Item) : GildedRoseItem {
    override fun update() {
        item.decreaseQuality()
        item.decreaseSellIn()
        item.decreaseQualityIfOutOfDate()
    }
}
