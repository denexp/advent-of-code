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
    @Test
    fun fewestNumberOfCubes() {
        val total = Day2Part2().fewestNumberOfCubes(
            listOf(
                listOf(
                    Day2.Cubes(8, "green"),
                    Day2.Cubes(6, "blue"),
                    Day2.Cubes(20, "red"),
                ),
                listOf(
                    Day2.Cubes(5, "blue"),
                    Day2.Cubes(4, "red"),
                    Day2.Cubes(13, "green"),
                ),
                listOf(
                    Day2.Cubes(5, "green"),
                    Day2.Cubes(1, "red"),
                ),
            )
        )
        val expected = listOf(
            Day2.Cubes(13, "green"),
            Day2.Cubes(6, "blue"),
            Day2.Cubes(20, "red"),
        )
        Assertions.assertEquals(expected, total)
    }

    @Test
    fun powerOfOne() {
        val total = Day2Part2().sumOfPower(listOf("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"))
        val expected = 1560
        Assertions.assertEquals(expected, total)
    }
    @Test
    fun day2Part2() {
        val input = "./src/test/kotlin/day2/Input".readLines()
        val total = Day2Part2().sumOfPower(input)
        val expected = 0
        Assertions.assertEquals(expected, total)
    }

}