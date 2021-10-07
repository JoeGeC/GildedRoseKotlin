package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ItemShould {
    @Test
    fun `Return string of properties`(){
        val name = "name"
        val sellIn = 1
        val quality = 2
        val item = Item(name, sellIn, quality)
        val expected = "$name, $sellIn, $quality"
        assertEquals(expected, item.toString())
    }
}