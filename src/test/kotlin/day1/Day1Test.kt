package day1

import Day1
import FileManager.readLines
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

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
        val expected = 11
        Assertions.assertEquals(expected, totalCalculation)
    }
    @Test
    fun sumOfFirstAndLast() {
        val totalCalculation = Day1().totalCalculation(listOf("123"))
        val expected = 13
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun sumOfMultiples() {
        val totalCalculation = Day1().totalCalculation(listOf("1awgass3", "awgya3ehge"))
        val expected = 46
        Assertions.assertEquals(expected, totalCalculation)
    }

    @Test
    fun example() {
        val totalCalculation = Day1().totalCalculation(listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        ))
        val expected = 142
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