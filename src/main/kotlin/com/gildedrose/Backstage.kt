package com.gildedrose

class Backstage(val item: Item) {
    fun updateQuality() {
        if (item.sellIn < 11)
            increaseQuality()
        if (item.sellIn < 6)
            increaseQuality()
    }

    fun reduceSellIn() { item.sellIn-- }

    private fun increaseQuality() {
        if (item.quality < 50) item.quality++
    }

    fun resetQuality() {
        if (item.sellIn < 0) item.quality = 0
    }

    fun reduceQuality() {
        if (item.quality > 0) item.quality--
    }
}
