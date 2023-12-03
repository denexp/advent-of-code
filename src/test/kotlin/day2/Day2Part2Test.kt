package day2

import FileManager.readLines
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Part2Test {
    @Test
    fun emptyList() {
        val total = Day2Part2().sumOfPower(emptyList<String>())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun emptyContent() {
        val total = Day2Part2().sumOfPower(listOf(""))
        val expected = 0
        Assertions.assertEquals(expected, total)
    }

}