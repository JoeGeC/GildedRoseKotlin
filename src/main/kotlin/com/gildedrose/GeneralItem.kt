package com.gildedrose

class GeneralItem(override val item: Item) : GildedRoseItem {
    override fun update() {
        reduceQuality(item)
        item.sellIn--
        if (item.sellIn < 0) reduceQuality(item)
    }

    private fun reduceQuality(item: Item) {
        if (item.quality > 0) item.quality--
    }
}
