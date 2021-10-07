package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private val agedBrie = "Aged Brie"
    private val sulfuras = "Sulfuras, Hand of Ragnaros"
    private val backstage = "Backstage passes to a TAFKAL80ETC concert"
    private val general = "A general item"

    fun updateQuality() {
        items.forEach { item ->
            var i: GildedRoseItem? = null
            if(itemIsBackstage(item)) i = Backstage(item)
            if(itemIsBrie(item)) i = AgedBrie(item)
            if(itemIsSulfuras(item)) i = Sulfuras(item)
            if(itemIsGeneral(item)) i = GeneralItem(item)
            i?.update()
        }
    }

    private fun itemIsGeneral(item: Item): Boolean  = item.name == general

    private fun itemIsBrie(item: Item) = item.name == agedBrie

    private fun itemIsSulfuras(item: Item) = item.name == sulfuras

    private fun itemIsBackstage(item: Item) = item.name == backstage
}

