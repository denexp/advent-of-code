package day2

class Day2Part2(val day2: Day2 = Day2()) {
    fun sumOfPower(input: List<String>): Int {
        input.ifEmpty { return 0 }
        return input.sumOf {
            it.ifEmpty { return@sumOf 0 }
            val cubes = day2.extractCubes(it)
            fewestNumberOfCubes(cubes).map { it.n }.reduce { acc, next ->
                acc * next
            }
        }
    }

    fun fewestNumberOfCubes(cubeList: List<List<Day2.Cubes>>): List<Day2.Cubes> {
        val cubes = cubeList.flatten().groupBy { it.color }
        return cubes.mapNotNull{
            var highestValue = 0
            for (i in it.value) {
                if (i.n > highestValue)
                    highestValue = i.n
            }
            it.value.find { it.n == highestValue }
        }
    }

}
