package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private val agedBrie = "Aged Brie"
    private val sulfuras = "Sulfuras, Hand of Ragnaros"
    private val backstage = "Backstage passes to a TAFKAL80ETC concert"

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != agedBrie && item.name != backstage) {
                if (item.quality > 0) {
                    if (item.name != sulfuras) {
                        item.quality--
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++

                    if (item.name == backstage) {
                        if (item.sellIn < 11)
                            increaseQuality(item)
                        if (item.sellIn < 6)
                            increaseQuality(item)
                    }
                }
            }

            if (item.name != sulfuras) {
                item.sellIn--
            }

            if (item.sellIn < 0) {
                if (item.name != agedBrie) {
                    if (item.name != backstage) {
                        if (item.quality > 0) {
                            if (item.name != sulfuras) {
                                item.quality--
                            }
                        }
                    } else {
                        item.quality = 0
                    }
                } else increaseQuality(item)
            }
        }
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < 50) {
            item.quality++
        }
    }

}

