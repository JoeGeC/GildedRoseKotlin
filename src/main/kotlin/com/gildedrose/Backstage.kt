package com.gildedrose

class Backstage(override val item: Item): GildedRoseItem {
    override fun update() {
        increaseQuality()
        updateQuality()
        reduceSellIn()
        resetQuality()
        if (item.sellIn < 0) reduceQuality()
    }

    private fun updateQuality() {
        if (item.sellIn < 11)
            increaseQuality()
        if (item.sellIn < 6)
            increaseQuality()
    }

    private fun reduceSellIn() { item.sellIn-- }

    private fun increaseQuality() {
        if (item.quality < 50) item.quality++
    }

    private fun resetQuality() {
        if (item.sellIn < 0) item.quality = 0
    }

    private fun reduceQuality() {
        if (item.quality > 0) item.quality--
    }
}
