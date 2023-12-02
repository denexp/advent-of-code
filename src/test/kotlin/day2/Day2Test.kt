package day2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day2Test {

    val loadedInfo = "Game 0: 12 red, 13 green, 14 blue"

    @Test
    fun emptyList() {
        val total = Day2().sumOfGameIds(emptyList<String>(), loadedInfo)
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun emptyContent() {
        val total = Day2().sumOfGameIds(listOf(""), loadedInfo)
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun possibleGame() {
        val total = Day2().sumOfGameIds(listOf("Game 1: 13 blue"), loadedInfo)
        val expected = 1
        Assertions.assertEquals(expected, total)
    }
}