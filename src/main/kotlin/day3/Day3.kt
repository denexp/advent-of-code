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

}
