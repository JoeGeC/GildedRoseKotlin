package com.gildedrose
private const val minQualityValue = 0
private const val maximumQualityValue = 50

fun Item.zeroQualityIfOutOfDate() {
    if (sellIn < 0) quality = 0
}

fun Item.increaseQualityIfAlmostOutOfDate() {
    if (sellIn < 6) increaseQuality()
}

fun Item.increaseQualityIfApproachingSellBy() {
    if (sellIn < 11) increaseQuality()
}

fun Item.increaseQualityIfOutOfDate() {
    if (sellIn < 0) increaseQuality()
}

fun Item.decreaseQualityIfOutOfDate() {
    if (sellIn < 0) decreaseQuality()
}

fun Item.decreaseSellIn() {
    sellIn--
}

fun Item.decreaseQuality() {
    if (itemNotAtMinQuality()) quality--
}

fun Item.increaseQuality() {
    if (itemNotAtMaxQuality()) quality++
}

private fun Item.itemNotAtMinQuality(): Boolean = quality > minQualityValue

private fun Item.itemNotAtMaxQuality(): Boolean = quality < maximumQualityValue