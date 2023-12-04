package day3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun emptyList() {
        val total = Day3().sumOfEngineNumbers(emptyList<String>())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun emptyContent() {
        val total = Day3().sumOfEngineNumbers(listOf(""))
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun ignoreDotAsSymbol() {
        val total = Day3().validSymbol(".".single())
        val expected = false
        Assertions.assertEquals(expected, total)
    }
}