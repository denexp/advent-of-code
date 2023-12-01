package day1

import Day1
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
    fun findFirst() {
        val totalCalculation = Day1().totalCalculation(listOf("1"))
        val expected = 1
        Assertions.assertEquals(expected, totalCalculation)
    }
}