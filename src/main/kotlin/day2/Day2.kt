package day2

class Day2 {
    data class Cubes(val n: Int, val color: String)
    fun sumOfGameIds(input: List<String>, loadedInfo: String): Int {
        val info = extractCubes(loadedInfo).flatten()
        input.ifEmpty { return 0 }
        return input.sumOf {
            val gameId = extractGame(it)
            val cubesSequence = extractCubes(it)
            validGame(cubesSequence, info, gameId)
        }
    }

    private fun validGame(cubesSequence: List<List<Cubes>>, loadedInfo: List<Cubes>, gameId: Int): Int {
        for (list in cubesSequence) {
            for (cubes in loadedInfo) {
                val c = list.find { it.color == cubes.color } ?: continue
                val match = c.n <= cubes.n
                if (!match)
                    return 0
            }
        }
        return gameId
    }

    //Game 1: 4 red, 8 green; 8 green, 6 red; 13 red, 8 green; 2 blue, 4 red, 4 green
    fun extractCubes(input: String): List<List<Cubes>> {
        val startIndex = input.indexOfFirst { it.toString() == ":" }
        if (startIndex == -1) return emptyList()
        val cubesBlock = input.substring(startIndex + 2, input.count())
        val cubesInfo = cubesBlock.split("; ")

        return cubesInfo.map {
            it.split(", ").map {
                it.split(" ").let {
                    Cubes(it.first().toInt(), it.last())
                }
            }
        }
    }
    fun extractGame(input: String): Int {
        input.ifEmpty { return 0 }
        val gameIndex = input.indexOfFirst { it.isDigit() }
        return input[gameIndex].digitToInt()
    }

}
