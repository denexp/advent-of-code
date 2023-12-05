package day3

import FileManager.readLines
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
        val expected = 23 to 87
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun adjacentNumbersInvalid() {
        val total = Day3().adjacentNumbers(3, "...*...14.".toCharArray())
        val expected = 0 to 0
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
    fun multiAdjacentNumbers() {
        val total = Day3().multiAdjacentNumbers("1*23.4&14.".toCharArray())
        val expected = listOf(1, 23, 4, 14)
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun multiAdjacentNumbersSharedValues() {
        val total = Day3().multiAdjacentNumbers("1*3=4.&14.".toCharArray())
        val expected = listOf(1, 3, 4, 14)
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun multiDiagonalNumbers() {
        val total = Day3().multiDiagonalNumbers(
            listOf(
                "46741.146.",
                "...*...#..",
                "..3.5..63.",
            )
        )
        val expected = listOf(46741, 3, 5, 146, 63)
        Assertions.assertTrue(expected.containsAll(total), "expected: $expected\nactual: $total")
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun multiDiagonalNumbersSharedValues() {
        val total = Day3().multiDiagonalNumbers(
            listOf(
                "46741.146.",
                ".=.*......",
                "..3.5..63.",
            )
        )
        val expected = listOf(46741, 3, 5)
        Assertions.assertTrue(expected.containsAll(total), "expected: $expected\nactual: $total")
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun sumOfEngineNumbersSingleLine() {
        val total = Day3().sumOfEngineNumbers(
            listOf(
                "4(6.1.-46.",
            )
        )
        val expected = 4 + 6 + 46
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun sumOfEngineNumbersExample() {
        val total = Day3().sumOfEngineNumbers(
            listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598..",
            )
        )
        val expected = 4361
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun day3() {
        val input = "./src/test/kotlin/day3/Input".readLines()
        val total = Day3().sumOfEngineNumbers(input)
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
}