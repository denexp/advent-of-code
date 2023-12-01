package day1

class Day1Part2 {
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
            (findFirst(it) + findLast(it)).toInt()
        }
    }

    private fun findFirst(input: String): String {
        val list = validNumbers.keys
        for (i in list.indices) {
            if (input.contains(list.elementAt(i))) {
                return validNumbers.values.elementAt(i)
            }
        }
        return "0"
    }
    private fun findLast(input: String): String {
        val list = validNumbers.keys
        for (i in list.indices.reversed()) {
            if (input.contains(list.elementAt(i))) {
                return validNumbers.values.elementAt(i)
            }
        }
        return "0"
    }
}
