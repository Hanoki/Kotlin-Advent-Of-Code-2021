package day02

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        input.map {
            val splitInput = it.split(" ")
            Pair(splitInput[0], splitInput[1].toInt())
        }.forEach {
            when (it.first) {
                "up" -> depth -= it.second
                "down" -> depth += it.second
                "forward" -> horizontal += it.second
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var aim = 0
        var depth = 0
        input.map {
            val splitInput = it.split(" ")
            Pair(splitInput[0], splitInput[1].toInt())
        }.forEach {
            when (it.first) {
                "up" -> {
                    aim -= it.second
                }
                "down" -> {
                    aim += it.second
                }
                "forward" -> {
                    horizontal += it.second
                    depth += aim * it.second
                }
            }
        }
        return horizontal * depth
    }

    val input = readInput("day02/Day02")
    println(part1(input))
    println(part2(input))
}
