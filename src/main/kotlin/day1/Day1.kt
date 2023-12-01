class Day1 {
    fun totalCalculation(input: List<String>): Int {
        input.ifEmpty { return 0 }
        return input.sumOf {
            (findFirst(it) + findLast(it)).toInt()
        }
    }

    private fun findFirst(input: String): String {
        val chars = input.toCharArray()
        for (i in chars.indices) {
            if (chars[i].isDigit()) {
                return chars[i].toString()
            }
        }
        return "0"
    }
    private fun findLast(input: String): String {
        val chars = input.toCharArray()
        for (i in chars.indices.reversed()) {
            if (chars[i].isDigit()) {
                return chars[i].toString()
            }
        }
        return "0"
    }

}
