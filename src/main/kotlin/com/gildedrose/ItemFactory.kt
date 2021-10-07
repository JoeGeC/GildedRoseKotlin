package com.gildedrose

class ItemFactory {
    private val agedBrie = "Aged Brie"
    private val sulfuras = "Sulfuras, Hand of Ragnaros"
    private val backstage = "Backstage passes to a TAFKAL80ETC concert"

    fun createGildedRoseItemFrom(item: Item): GildedRoseItem {
        if (itemIsBackstage(item)) return Backstage(item)
        if (itemIsBrie(item)) return AgedBrie(item)
        if (itemIsSulfuras(item)) return Sulfuras(item)
        return GeneralItem(item)
    }

    private fun itemIsBrie(item: Item) = item.name == agedBrie

    private fun itemIsSulfuras(item: Item) = item.name == sulfuras

    private fun itemIsBackstage(item: Item) = item.name == backstage
}