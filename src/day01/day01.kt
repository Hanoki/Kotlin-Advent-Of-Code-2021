package day01

import readInput

fun main() {
    fun part1(input: List<String>) = input.map { it.toInt() }.zipWithNext().filter { it.second > it.first }.size

    fun part2(input: List<String>): Int {
        val depths = input.map { it.toInt() }
        val groupedDepths = arrayListOf<Int>()
        for (i in depths.indices) {
            if (i <= depths.size - 3) {
                groupedDepths.add(depths[i] + depths[i + 1] + depths[i + 2])
            }
        }
        return groupedDepths.zipWithNext().filter { it.second > it.first }.size
    }

    val input = readInput("day01/Day01")
    println(part1(input))
    println(part2(input))
}
