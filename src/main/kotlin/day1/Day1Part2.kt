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
            day1.sumElement(
                replaceForDigit(it, false) + replaceForDigit(it, true)
            )
        }
    }

    private fun replaceForDigit(input: String, reversedRange: Boolean): String {
        val chars = input.toCharArray()
        var word = String()
        val charsIndices = if (reversedRange) chars.indices.reversed() else chars.indices
        for (i in charsIndices) {
            if (chars[i].isDigit()) {
                word = String()
                continue
            }
            if (reversedRange)
                word = "${chars[i]}$word"
            else
                word += chars[i]
            for (j in validNumbers.keys.indices) {
                if(word.contains(validNumbers.keys.elementAt(j))) {
                    return input.replace(validNumbers.keys.elementAt(j), validNumbers[validNumbers.keys.elementAt(j)] ?: word)
                }
            }
        }
        return input
    }

    private fun isValid(input: String, list: Set<String>, i: Int) =
        input.contains(list.elementAt(i))
}
