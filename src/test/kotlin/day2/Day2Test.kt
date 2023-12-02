package day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun emptyList() {
        val total = Day2().sumOfGameIds(emptyList<String>())
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun emptyContent() {
        val total = Day2().sumOfGameIds(listOf(""))
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun possibleGame() {
        val total = Day2().sumOfGameIds(listOf("Game 1: 13 blue"))
        val expected = 1
        Assertions.assertEquals(expected, total)
    }
}