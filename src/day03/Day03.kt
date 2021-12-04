package day03

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        val binaryNumbers = arrayListOf<String>()
        for (i in 0 until input.first().length) {
            binaryNumbers.add("")
            input.forEach {
                binaryNumbers[i] = binaryNumbers[i] + it[i]
            }
        }
        binaryNumbers.forEach { number ->
            val ones = number.count { it == '1' }
            val zeros = number.count { it == '0' }
            gamma += if (ones > zeros) "1" else "0"
            epsilon += if (ones > zeros) "0" else "1"
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun filterList(input: List<String>, index: Int, oxygen: Boolean): List<String> {
        return if (input.size > 1) {
            var indexBits = ""
            input.forEach { indexBits += it[index] }
            val ones = indexBits.count { it == '1' }
            val zeros = indexBits.count { it == '0' }
            val prevalentChar = if (ones >= zeros) {
                if (oxygen) '1' else '0'
            } else {
                if (oxygen) '0' else '1'
            }
            input.filter { it[index] == prevalentChar }
        } else {
            input
        }
    }

    fun computeOxygenAndCo2(oxygenInput: List<String>, co2Input: List<String>, index: Int = 0): Pair<String, String> {
        if (oxygenInput.size == 1 && co2Input.size == 1) {
            return Pair(oxygenInput.first(), co2Input.first())
        }
        return computeOxygenAndCo2(filterList(oxygenInput, index, true), filterList(co2Input, index, false), index + 1)
    }

    fun part2(input: List<String>): Int {
        val (oxygen, co2) = computeOxygenAndCo2(input, input, 0)
        return oxygen.toInt(2) * co2.toInt(2)
    }

    val input = readInput("day03/Day03")
    println(part1(input))
    println(part2(input))
}
