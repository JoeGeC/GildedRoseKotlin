package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private val agedBrie = "Aged Brie"
    private val sulfuras = "Sulfuras, Hand of Ragnaros"
    private val backstage = "Backstage passes to a TAFKAL80ETC concert"
    private val general = "A general item"

    fun updateQuality() {
        items.forEach { item ->
            var i: Backstage? = null
            if(itemIsBackstage(item)) i = Backstage(item)

            if (itemIsBrie(item) || i?.item?.name == backstage)
                increaseQuality(item)
            if (itemIsGeneral(item))
                reduceQuality(item)

            if (i?.item?.name == backstage)
                i.updateQuality()

            if (itemIsBrie(item) || i?.item?.name == backstage || itemIsGeneral(item))
                item.sellIn--

            if (i?.item?.name == backstage)
                if (item.sellIn < 0) item.quality = 0

            if (itemIsBrie(item) || itemIsSulfuras(item)) {
                if (item.sellIn < 0) increaseQuality(item)
            } else if (i?.item?.name == backstage || itemIsGeneral(item)) {
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

