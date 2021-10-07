package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private val agedBrie = "Aged Brie"
    private val sulfuras = "Sulfuras, Hand of Ragnaros"
    private val backstage = "Backstage passes to a TAFKAL80ETC concert"

    fun updateQuality() {
        items.forEach { item ->
            if (!itemIsBrie(item) && !itemIsBackstage(item)) {
                if (item.quality > 0)
                    reduceQuality(item)
            } else {
                if (item.quality < 50) {
                    item.quality++

                    if (itemIsBackstage(item)) {
                        if (item.sellIn < 11)
                            increaseQuality(item)
                        if (item.sellIn < 6)
                            increaseQuality(item)
                    }
                }
            }

            if (!itemIsSulfuras(item))
                item.sellIn--

            if (item.sellIn < 0) {
                if (!itemIsBrie(item)) {
                    if (itemIsBackstage(item))
                        item.quality = 0
                    else if (item.quality > 0)
                        reduceQuality(item)
                } else increaseQuality(item)
            }
        }
    }

    private fun itemIsBrie(item: Item) = item.name == agedBrie

    private fun itemIsSulfuras(item: Item) = item.name == sulfuras

    private fun itemIsBackstage(item: Item) = item.name == backstage

    private fun reduceQuality(item: Item) {
        if (item.name != sulfuras) {
            item.quality--
        }
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < 50) {
            item.quality++
        }
    }

}

