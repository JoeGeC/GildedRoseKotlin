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
            i?.update()

            if (itemIsGeneral(item))
                reduceQuality(item)

            if (itemIsGeneral(item))
                item.sellIn--

            if (itemIsGeneral(item)) {
                if (item.sellIn < 0) reduceQuality(item)
            }
        }
    }

    private fun itemIsGeneral(item: Item): Boolean  = item.name == general

    private fun itemIsBrie(item: Item) = item.name == agedBrie

    private fun itemIsSulfuras(item: Item) = item.name == sulfuras

    private fun itemIsBackstage(item: Item) = item.name == backstage

    private fun reduceQuality(item: Item) {
        if (item.quality > 0)
            item.quality--
    }

    private fun increaseQuality(item: Item) {
        if (item.quality < 50)
            item.quality++
    }
}

