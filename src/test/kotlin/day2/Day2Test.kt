package day2

import FileManager.readLines
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
    fun gameId() {
        val total = Day2().sumOfGameIds(listOf("Game 10: 1 blue"), loadedInfo)
        val expected = 10
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun possibleGame() {
        val total = Day2().sumOfGameIds(listOf("Game 1: 13 blue"), loadedInfo)
        val expected = 1
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun nonPossibleGameComplete() {
        val total = Day2().sumOfGameIds(listOf("Game 1: 4 red, 8 green; 8 green, 6 red; 13 red, 8 green; 2 blue, 4 red, 4 green"), loadedInfo)
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun example() {
        val total = Day2().sumOfGameIds(listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        ), loadedInfo)
        val expected = 8
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun day2() {
        val input = "./src/test/kotlin/day2/Input".readLines()
        val total = Day2().sumOfGameIds(input, loadedInfo)
        val expected = 0
        Assertions.assertEquals(expected, total)
    }
}