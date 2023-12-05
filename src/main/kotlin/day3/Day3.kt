package day3

class Day3 {
    fun sumOfEngineNumbers(input: List<String>): Int {
        input.ifEmpty { return 0 }

        return multiAdjacentNumbers(input.first().toCharArray()).sum()
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

        val adjacents = { k: Int, pChars: CharArray?, nChars: CharArray? ->
            var pNumbers = pChars?.let { adjacentNumbers(k, it) }
            val nNumbers = nChars?.let { adjacentNumbers(k, it) }

            if (pNumbers?.second == nNumbers?.first) {
                pNumbers = pNumbers?.copy(second = 0)
            }
            listOfNotNull(pNumbers?.toList(), nNumbers?.toList())
        }

        return adjacents(j, previous, next).flatten().filter { it != 0 }
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
