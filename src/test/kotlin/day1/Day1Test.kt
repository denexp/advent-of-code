package day1

import Day1
import FileManager.readLines
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun emptyList() {
        val totalCalculation = Day1().totalCalculation(emptyList<String>())
        val expected = 0
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun emptyContent() {
        val totalCalculation = Day1().totalCalculation(listOf(""))
        val expected = 0
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun sumOfFirst() {
        val totalCalculation = Day1().totalCalculation(listOf("1"))
        val expected = 2
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun sumOfFirstAndLast() {
        val totalCalculation = Day1().totalCalculation(listOf("123"))
        val expected = 4
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun sumOfMultiples() {
        val totalCalculation = Day1().totalCalculation(listOf("1awgass3", "awgya3ehge"))
        val expected = 10
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun day1Solution() {
        val input = "./src/test/kotlin/day1/Input".readLines()
        val totalCalculation = Day1().totalCalculation(input)
        val expected = 0
        Assertions.assertEquals(expected, totalCalculation)
    }
}