package day3

class Day3 {
    fun sumOfEngineNumbers(input: List<String>): Int {

        return 0
    }

    fun nextNumber(i: Int, chars: CharArray): Int? {
        var number = ""
        for (j in i until chars.count()) {
            if (chars[j].isDigit())
                number += chars[j]
            else
                break
        }
        return number.toIntOrNull()
    }

    fun validSymbol(input: Char) = !input.isLetterOrDigit() && input != ".".single()

}
