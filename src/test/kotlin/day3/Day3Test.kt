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
    @Test
    fun detectDotAsSymbol() {
        val total = Day3().validSymbol("*".single())
        val expected = true
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun nonValidNumbers() {
        val total = Day3().sumOfEngineNumbers(listOf("467..114.."))
        val expected = 0
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun nextNumberLimit() {
        val total = Day3().nextNumber(9, ".......14*".toCharArray())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun nextNumberValid() {
        val total = Day3().nextNumber(3, "...*123..14.".toCharArray())
        val expected = 123
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun nextNumberInvalid() {
        val total = Day3().nextNumber(3, "...*...14.".toCharArray())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun previousNumberLimit() {
        val total = Day3().previousNumber(0, "*......14.".toCharArray())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun previousNumberValid() {
        val total = Day3().previousNumber(3, "122*...14.".toCharArray())
        val expected = 122
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun previousNumberInvalid() {
        val total = Day3().previousNumber(3, "...*...14.".toCharArray())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
}