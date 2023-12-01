package day1

import Day1

class Day1Part2(val day1: Day1 = Day1()) {
    val validNumbers = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
    fun totalCalculation(input: List<String>): Int {
        input.ifEmpty { return 0 }
        return input.sumOf {
            val element = toDigit(it)
            day1.sumElement(element)
        }
    }

    private fun toDigit(input: String): String {
        val list = validNumbers.keys
        for (i in list.indices) {
            if (isValid(input, list, i)) {
                return toDigit(input.replace(list.elementAt(i), validNumbers.values.elementAt(i)))
            }
        }
        return input
    }

    private fun findFirst(input: String): String {
        val list = validNumbers.keys
        for (i in list.indices) {
            if (isValid(input, list, i)) {
                return validNumbers.values.elementAt(i)
            }
        }
        return "0"
    }
    private fun findLast(input: String): String {
        val list = validNumbers.keys
        for (i in list.indices.reversed()) {
            if (isValid(input, list, i)) {
                return validNumbers.values.elementAt(i)
            }
        }
        return "0"
    }

    private fun isValid(input: String, list: Set<String>, i: Int) =
        input.contains(list.elementAt(i))
}
