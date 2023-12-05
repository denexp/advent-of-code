package day3

class Day3 {
    fun sumOfEngineNumbers(input: List<String>): Int {
        input.ifEmpty { return 0 }
        return multiDiagonalNumbers(input).sum() +
                input.sumOf {
                    multiAdjacentNumbers(it.toCharArray()).sum()
                }
    }

    fun nextNumber(i: Int, chars: CharArray): Int {
        var number = ""
        var index = i+1

        if(chars[i].isDigit()) {
            index = i
            val previousChars = chars.copyOfRange(0, i)
            number = findPrevious(previousChars, number)
        }

        number = findNext(index, chars, number)
        return number.toIntOrNull() ?: 0
    }
    fun previousNumber(i: Int, chars: CharArray): Int {
        val index = if(!chars[i].isDigit()) i else i+1
        val previousChars = chars.copyOfRange(0, index)
        var number = ""
        number = findNext(index, chars, number)
        number = findPrevious(previousChars, number)
        return number.toIntOrNull() ?: 0
    }

    private fun findNext(index: Int, chars: CharArray, number: String): String {
        var number1 = number
        for (k in index until chars.count()) {
            if (chars[k].isDigit())
                number1 += chars[k]
            else
                break
        }
        return number1
    }

    private fun findPrevious(previousChars: CharArray, number: String): String {
        var number1 = number
        for (j in previousChars.indices.reversed()) {
            if (previousChars[j].isDigit())
                number1 = "${previousChars[j]}$number1"
            else
                break
        }
        return number1
    }

    fun validSymbol(input: Char) = !input.isLetterOrDigit() && input != ".".single()
    fun adjacentNumbers(i: Int, chars: CharArray): Pair<Int, Int> {
        var (previous, next) =  previousNumber(i, chars) to nextNumber(i, chars)
        if ((chars[i].isDigit() && previous == next) ) {
            previous = 0
        }
        return previous to next
    }

    fun diagonalNumbers(i: Int, j: Int, input: List<CharArray>): List<Int> {
        val previous = input.getOrNull(i-1)
        val next = input.getOrNull(i+1)

        val pNumbers = previous?.let { adjacentNumbers(j, it) }
        val nNumbers = next?.let { adjacentNumbers(j, it) }
        val adjacents = listOfNotNull(pNumbers?.toList(), nNumbers?.toList())
        return adjacents.flatten().filter { it != 0 }
    }

    fun multiAdjacentNumbers(input: CharArray): List<Int> {
        val symbolIndices = input.mapIndexed { i, it -> i to validSymbol(it) }
            .filter { it.second }
            .map { it.first }
        val ad = symbolIndices.map { adjacentNumbers(it, input) }
        val e = mutableListOf<Int>()
        for (i in 0 until ad.count()) {
            val actual = ad[i]
            val next = ad.getOrNull(i+1)
            if (i == 0)
                e.add(actual.first)
            if (actual.second == next?.first) {
                e.add(actual.second)
                e.add(next.second)
            } else {
                if (i == 0)
                    e.add(actual.second)
                if (next != null) {
                    e.add(next.first)
                    e.add(next.second)
                }
            }
        }

        return e.filter { it != 0 }
    }

    fun multiDiagonalNumbers(input: List<String>): List<Int> {
        val symbolIndices = input.mapIndexed { i, it ->
            i to it.mapIndexed { index, char -> index to validSymbol(char) }
                .filter { it.second }
                .map { it.first }
        }
        return symbolIndices.map { index ->
            index.second.map {
                diagonalNumbers(index.first, it, input.map { it.toCharArray() })
            }.flatten().toSet()
        }.flatten()
    }

}
