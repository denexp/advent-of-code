package day3

class Day3 {
    fun sumOfEngineNumbers(input: List<String>): Int {

        return 0
    }

    fun nextNumber(i: Int, chars: CharArray): Int {
        var number = ""
        for (j in i+1 until chars.count()) {
            if (chars[j].isDigit())
                number += chars[j]
            else
                break
        }
        return number.toIntOrNull() ?: 0
    }
    fun previousNumber(i: Int, chars: CharArray): Int {
        val previousChars = chars.copyOfRange(0, i)
        var number = ""
        for (j in previousChars.indices.reversed()) {
            if (previousChars[j].isDigit())
                number = "${previousChars[j]}$number"
            else
                break
        }
        return number.toIntOrNull() ?: 0
    }

    fun validSymbol(input: Char) = !input.isLetterOrDigit() && input != ".".single()
    fun adjacentNumbers(i: Int, chars: CharArray): List<Int> {
        return listOf(
            previousNumber(i, chars),
            nextNumber(i, chars)
        ).filter { it != 0 }
    }

    fun diagonalNumbers(i: Int, j: Int, input: List<CharArray>): List<Int> {
        val previous = input.getOrNull(i-1)
        val next = input.getOrNull(i+1)
        return listOfNotNull(
            previous?.let { adjacentNumbers(j, it) },
            next?.let { adjacentNumbers(j, it) }
        ).flatten()
    }

    fun multiAdjacentNumbers(input: CharArray): List<Int> {
        val symbolIndices = input.mapIndexed { i, it -> i to validSymbol(it) }
            .filter { it.second }
            .map { it.first }
        return symbolIndices.map {
            adjacentNumbers(it, input)
        }.flatten()
    }

}
