package day1

import FileManager.readLines
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1part2Test {

    @Test
    fun emptyList() {
        val totalCalculation = Day1Part2().totalCalculation(emptyList<String>())
        val expected = 0
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun emptyContent() {
        val totalCalculation = Day1Part2().totalCalculation(listOf(""))
        val expected = 0
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun sumOfFirst() {
        val totalCalculation = Day1Part2().totalCalculation(listOf("two"))
        val expected = 22
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun sumOfFirstAndLast() {
        val totalCalculation = Day1Part2().totalCalculation(listOf("twotwo"))
        val expected = 22
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun sumOfFirstAndLastDifferent() {
        val totalCalculation = Day1Part2().totalCalculation(listOf("two1nine"))
        val expected = 29
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun sumOfFirstAndLastDigits() {
        val totalCalculation = Day1Part2().totalCalculation(listOf("4nineeightseven2"))
        val expected = 42
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun sumOfFirstAndLastSharedChar() {
        val totalCalculation = Day1Part2().totalCalculation(listOf("eightwothree"))
        val expected = 83
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun examplePart2() {
        val totalCalculation = Day1Part2().totalCalculation(listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
        ))
        val expected = 281
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun day1part2() {
        val input = "./src/test/kotlin/day1/Input".readLines()
        val totalCalculation = Day1Part2().totalCalculation(input)
        val expected = 54418
        Assertions.assertEquals(expected, totalCalculation)
    }
}