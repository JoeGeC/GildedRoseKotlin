package com.gildedrose

class Backstage(val item: Item) {
    fun updateQuality() {
        if (item.sellIn < 11)
            increaseQuality()
        if (item.sellIn < 6)
            increaseQuality()
    }

    private fun increaseQuality() {
        if (item.quality < 50) item.quality++
    }

    private fun reduceQuality() {
        if (item.quality > 0) item.quality--
    }
}
