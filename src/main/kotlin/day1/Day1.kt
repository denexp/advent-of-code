class Day1 {
    fun totalCalculation(input: List<String>): Int {
        input.ifEmpty { return 0 }
        return input.first().toIntOrNull() ?: 0
    }

}
