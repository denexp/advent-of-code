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
}