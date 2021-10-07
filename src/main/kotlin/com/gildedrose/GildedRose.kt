package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            val gildedRoseItem = ItemFactory().createGildedRoseItemFrom(item)
            gildedRoseItem.update()
        }
    }
}

