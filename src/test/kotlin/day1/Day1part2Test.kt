package day1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day1part2Test {

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
}