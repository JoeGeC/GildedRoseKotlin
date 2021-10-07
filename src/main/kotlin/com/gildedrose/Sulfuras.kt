package com.gildedrose

class Sulfuras(override val item: Item) : GildedRoseItem {
    override fun update() {
        item.decreaseQualityIfOutOfDate()
    }
}
