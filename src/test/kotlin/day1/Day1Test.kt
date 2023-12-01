package day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun emptyList() {
        val totalCalculation = Day1().totalCalculation(emptyList<String>())
        val expected = 0
        Assertions.assertEquals(expected, totalCalculation)
    }
}