class Day1 {
    fun totalCalculation(input: List<String>): Int {
        input.ifEmpty { return 0 }
        return input.sumOf { findFirst(it) + findLast(it) }
    }

    private fun findFirst(input: String): Int {
        val chars = input.toCharArray()
        for (i in chars.indices) {
            if (chars[i].isDigit()) {
                return chars[i].digitToIntOrNull() ?: 0
            }
        }
        return 0
    }
    private fun findLast(input: String): Int {
        val chars = input.toCharArray()
        for (i in chars.indices.reversed()) {
            if (chars[i].isDigit()) {
                return chars[i].digitToIntOrNull() ?: 0
            }
        }
        return 0
    }

}
