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
    @Test
    fun adjacentNumbers() {
        val total = Day3().adjacentNumbers(3, ".23*87.14.".toCharArray())
        val expected = listOf(23, 87)
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun adjacentNumbersInvalid() {
        val total = Day3().adjacentNumbers(3, "...*...14.".toCharArray())
        val expected = emptyList<Int>()
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun diagonalNumbers() {
        val total = Day3().diagonalNumbers(1, 3,
            listOf(
                "467..114..",
                "...*......",
                "..3.5..63.",
            ).map { it.toCharArray() }
        )
        val expected = listOf(467, 3, 5)
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun validNumbers() {
        val total = Day3().validNumbers(listOf("1*23.4&14."))
        val expected = listOf(1, 23, 4, 14)
        Assertions.assertEquals(expected, total)
    }
}