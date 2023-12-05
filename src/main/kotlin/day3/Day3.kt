package day3

class Day3 {
    fun sumOfEngineNumbers(input: List<String>): Int {

        return 0
    }

    fun nextNumber(i: Int, chars: CharArray): Int {
        var number = ""
        var index = i+1

        if(chars[i].isDigit()) {
            index = i
            val previousChars = chars.copyOfRange(0, i)
            for (j in previousChars.indices.reversed()) {
                if (previousChars[j].isDigit())
                    number = "${previousChars[j]}$number"
                else
                    break
            }
        }

        for (k in index until chars.count()) {
            if (chars[k].isDigit())
                number += chars[k]
            else
                break
        }
        return number.toIntOrNull() ?: 0
    }
    fun previousNumber(i: Int, chars: CharArray): Int {
        val index = if(!chars[i].isDigit()) i else i+1
        val previousChars = chars.copyOfRange(0, index)
        var number = ""
        for (k in index until chars.count()) {
            if (chars[k].isDigit())
                number += chars[k]
            else
                break
        }
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
        var (previous, next) =  previousNumber(i, chars) to nextNumber(i, chars)
        if (chars[i].isDigit() && previous == next) {
            previous = 0
        }
        return listOf(previous, next).filter { it != 0 }
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

    fun multiDiagonalNumbers(input: List<CharArray>): List<Int> {
        val symbolIndices = input.mapIndexed { i, it ->
            i to it.mapIndexed { index, char -> index to validSymbol(char) }
                .filter { it.second }
                .map { it.first }
        }
        return symbolIndices.map { index ->
            index.second.map {
                diagonalNumbers(index.first, it, input)
            }.flatten()
        }.flatten()
    }

}
